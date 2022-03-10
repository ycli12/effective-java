package singleton;

// 1、类似于公共属性方法
// 2、但更简洁，无偿提供了序列化机制，可以防止复杂的序列化也能保证单例模式
// 2.1 枚举类如何实现序列化，Java的序列化机制针对枚举类型是特殊处理的。
//     简单来讲，在序列化枚举类型时，只会存储枚举类的引用和枚举常量的名称。
//     随后的反序列化的过程中，这些信息被用来在运行时环境中查找存在的枚举类型对象。
// 2.2 当单例类被多个类加载器加载，如何还能保持单例？——用多个类加载器的父类来加载单例类。
// 3、可以防止反射也能保证单例模式，唯一的构造方法会检查该类**是否ENUM修饰**，如果是则抛出异常，反射失败
public enum ElvisByEnum {
    INSTANCE;

    // 确认枚举类每次都返回同样的实例
    public static void main(String[] args) {
        ElvisByEnum e1 = ElvisByEnum.INSTANCE;
        ElvisByEnum e2 = ElvisByEnum.INSTANCE;
        assert e1 == e2;
    }
}
