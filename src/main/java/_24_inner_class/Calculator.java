package _24_inner_class;

import java.util.HashMap;

public class Calculator {
    // 2、静态内部类作为外部的帮助类：Calculator.Operation.PLUS
    // 6、静态内部类的好处是只被一个类对象引用，而非静态内部类每个实例都有一个隐藏的类对象指向它
    //   因此，如果在非静态内部类的情况下，内部类没有被释放，那么外部类也永远不会被释放，造成内存泄漏
    // 7、静态类和非静态类的区别在于一个类有一个还是一个实例有一个
    public static enum Operation {
        PLUS, MINUS;
    }

    public static void main(String[] args) {
        System.out.println(Operation.PLUS);
    }
}
