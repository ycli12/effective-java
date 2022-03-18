package _26_use_generic_type;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;

public class GenericType {
    // 1、没有参数化类的类型称为原始类型，主要是为了兼容性
    private final Collection stampsUsingRawType = new LinkedList();

    // 2、原始类型无法保证其中的变量类型
    private void whyRawTypeMayHaveProblem() {
        // 不小心将Coin放入了一个Stamp集合中，因为原始类型没有检查，因此这是允许的
        // 原始类型只是默认会存入一种类型，但实际上这是不可能保证的
        stampsUsingRawType.add(new Coin());

        for (Object stamp : stampsUsingRawType) {
            // 取出来的时候就报错了！
            Stamp stamp1 = (Stamp) stamp;
            System.out.println(stamp1);
        }
    }

    // 3、多了参数化类型Stamp，是泛型
    private final Collection<Stamp> stampsUsingGenericType = new LinkedList<>();

    // 4、泛型如果使用错误的类型在编译的时候就报错了！
    private void genericTypeShouldComplainIfTypeIsNotRightWhenCompile() {
//        // 编译报错！因为stampsUsingGenericType在声明的时候已经给了参数化类型Stamp
//        // 而这里给了Coin类型，在编译的时候就直接报错了，进一步防止了报错！
//        stampsUsingGenericType.add(new Coin());
//
//        for (Object stamp : stampsUsingGenericType) {
//            // 取出来的时候就报错了！
//            Stamp stamp1 = (Stamp) stamp;
//            System.out.println(stamp1);
//        }
    }

    // 5、Object类型的泛型跟原始类型的区别：
    // 5.1：松散地说，前者已经选择了泛型类型系统，而后者明确地告诉编译器，它能够保存任何类型的对象，但还是有类型的，只是是所有类型
    private final Collection<Object> stampsUsingGenericTypeObject = new LinkedList<>();

    // 5.2：List<String>无法赋值给List<Object>，但能赋值给原始类型List
    // 下面的例子可以添加任何类型的变量，非常危险
    private void unsafeAdd(Collection collection, Object o) {
        // 会产生一个unchecked warning，
        collection.add(o);
    }

    private void testUnsafeAdd() {
        unsafeAdd(stampsUsingGenericType, new Coin());
        unsafeAdd(stampsUsingGenericTypeObject, new Coin());
        unsafeAdd(stampsUsingGenericType, new Coin());
    }

    // 不会运行
    private void add(Collection<Object> collection, Object o) {
        collection.add(o);
    }

    // 从这两个例子可以看到泛型比原始类型的约束性更强，不会那么随便！
    // 我们不想约束，所以我们很有困难会选择原始类型，但这是错的，因为我们不想付出代价
    private void testAdd() {
        // 三个只有中间的Collection<Object>类型才能编译成功
//        add(stampsUsingGenericType, new Coin());
//        add(stampsUsingGenericTypeObject, new Coin());
//        add(stampsUsingGenericType, new Coin());
    }

    // 6、原始类型的另外一种危险用法，因为s1和s2有可能被放入任何其他类型
    static int numElementInCommon(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result += 1;
            }
        }
        return result;
    }

    // 7、无限制通配符和原始类型的区别
    // 无限制通配符不能放入任何类型的对象，如果不想这种限制，可以使用泛型方法或者有限制的通配符类型
//    static int numElementInCommon(Set<?> s1, Set<?> s2) {
//
//    }

    // 8、





    public static void main(String[] args) {
//        new GenericType().whyRawTypeMayHaveProblem();
//        new GenericType().genericTypeShouldComplainIfTypeIsNotRightWhenCompile();
        new GenericType().testUnsafeAdd();
    }
}
