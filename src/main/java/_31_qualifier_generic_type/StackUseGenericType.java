package _31_qualifier_generic_type;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.omg.CORBA.Object;

import java.util.*;

public class StackUseGenericType<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public StackUseGenericType() {
        // 原来的地方将E换为Object会出错
        // elements = new E[DEFAULT_INITIAL_CAPACITY];
        // 强制类型转化防止出错
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    public void pushAll1(Iterable<E> src) {
        for (E e : src) {
            push(e);
        }
    }

    public void pushAll2(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    public void popAll1(Collection<E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }

    public void popAll2(Collection<? super E> dst) {
        while(!isEmpty()) {
            dst.add(pop());
        }
    }

    public static void main(String[] args) {
        StackUseGenericType<Number> stack = new StackUseGenericType<>();
        Iterable<Integer> iterator = new LinkedList<>();
        // 1、我们期望一个Number里面可以存放Integer类型也是合理的
//        stack.pushAll1(iterator);
        // 2、完美
        stack.pushAll2(iterator);
        // 3、我们同样期望有更父类的容器比如Collection<Object>可以存放E（Number）类型
        stack.popAll1(new LinkedList<Number>());
        // 4、完美
        stack.popAll2(new LinkedList<java.lang.Object>());
    }
}