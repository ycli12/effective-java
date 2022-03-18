package _29_prefer_generic_type;

import org.omg.CORBA.Object;

import java.util.Arrays;
import java.util.EmptyStackException;

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

    public static void main(String[] args) {
        StackUseGenericType<String> stack = new StackUseGenericType<>();
        for (String arg : args) {
            stack.push(arg);
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}