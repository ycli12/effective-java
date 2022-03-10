package singleton;

// 1、简单
public class ElvisByInnerStaticClass {
    private ElvisByInnerStaticClass() {}

    // 2、懒汉式，只有用到的时候才会随着类的加载而加载，而且线程安全
    private static class HolderClass {
        // 3、类变量只有一个
        // 为啥不把这个直接移到ElvisByInnerStaticClass类中？这样不能实现懒汉式！
        private static final ElvisByInnerStaticClass instance = new ElvisByInnerStaticClass();
    }

    public static ElvisByInnerStaticClass getInstance() {
        return HolderClass.instance;
    }

    public static void main(String[] args) {
        ElvisByInnerStaticClass e1 = getInstance();
        ElvisByInnerStaticClass e2 = getInstance();
        assert e1 == e2;
    }
}
