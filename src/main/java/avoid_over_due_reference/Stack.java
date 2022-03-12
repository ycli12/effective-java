package avoid_over_due_reference;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

//    // 没有消除对对象的引用，造成内存泄漏
//    public Object pop() {
//        if (size == 0)
//            throw new EmptyStackException();
//
//        return elements[--size];
//    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();

        Object result = elements[--size];
        // 1、消除引用避免内存泄漏，数组、List、Map、缓存等都任意造成这样的问题
        // 2、elements[size]被错误的用到的时候会抛出空指针异常，而不是出现一些奇怪的现象
        // 3、缓存清理对象的方式
        // 3.1 WeakHashMap 弱引用，当没有其他强引用指向的时候会被GC
        // 3.2 LRU等当添加新的缓存而缓存不够时清除过期缓存
        // 4、监听器如果客户没有注销，那么也可能不会被清除
        elements[size] = null;
        return result;
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}