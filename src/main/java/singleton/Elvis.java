package singleton;

import java.io.Serializable;

public class Elvis implements Serializable {
    // 2、公共属性的做法比较简单
    public static final Elvis INSTANCE = new Elvis();

    // 1、私有构造方法只能自己调用自己
    // 但通过反射AccessibleObject.setAccessible还是可以调用构造函数，
    // 可以在构造函数中进一步防御，第二次调用的时候抛出异常
    private Elvis() {}

    // 3、可以进一步修改，比如一个线程一个实例
    // 4、可以编写一个泛型单例工厂（30？）
    // 5、可以直接 Elvis::instance 等同于  Supplier<Elvis>
    public Elvis getInstance() {
        return INSTANCE;
    }

    // 6、防止序列化
    // https://stackoverflow.com/questions/1168348/java-serialization-readobject-vs-readresolve
    private Object readResolve() {
        // readResolve在readObject之后调用，会替换掉readObject弄出来的实例（这个实例后面会被gc掉）
        return INSTANCE;
    }


    public void leaveTheBuilding() {}
}