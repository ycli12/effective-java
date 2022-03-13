package clone;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    // 3、克隆后需要设置，不能设置为final
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    // Ensure space for at least one more element.
    private void ensureCapacity() {
        if (elements.length == size)

            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    // 2、直接调用super.clone()，原来的对象和克隆后的对象会共用一个elements，造成混乱
    @Override
    protected Stack clone() {
        try {
            Stack result = (Stack)super.clone();
            // 2.1、重新复制一份elements
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            // 因为实现了Cloneable接口所以不可能到这里
            throw new AssertionError();
        }
    }
}
