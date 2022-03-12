package private_constructor;

public class UtilClass {
    // 覆盖默认的构造器，防止实例化
    private UtilClass() {
        throw new AssertionError();
    }
}
