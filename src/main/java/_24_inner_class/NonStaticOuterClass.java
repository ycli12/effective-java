package _24_inner_class;

public class NonStaticOuterClass {
    private int value = 0;
    private NonStaticInnerClass innerInstance = new NonStaticInnerClass();

    public class NonStaticInnerClass {
        void addOuterClassValue() {
            // 4、内部类可以直接访问外部类的变量，跟一个类内部的一个叛徒一样
            // 5、基于以上特性，因此，我们可以设置内部类为Adapater，向外面展示一个不一样的外部类
            //    比如JDK中各种容器（Set、List）的Iterator
            value += 1;
        }
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        // 3、非静态内部类跟非静态内部是关联在一起的
        NonStaticOuterClass nonStaticOuterClass = new NonStaticOuterClass();
        NonStaticInnerClass nonStaticInnerClass = nonStaticOuterClass.new NonStaticInnerClass();
        nonStaticInnerClass.addOuterClassValue();
        System.out.println(nonStaticOuterClass.getValue());
    }
}
