package clone;

public class  MyCloneableClass implements Cloneable{
    private int myField;

    // 4、复制构造方法
    public MyCloneableClass(MyCloneableClass old) {
        this.myField = old.getMyField();
    }

    public int getMyField() {
        return myField;
    }

    // 5、静态工厂
    public static MyCloneableClass newInstance(MyCloneableClass old) {
        // ...
        return null;
    }

    @Override
    protected MyCloneableClass clone() {
        try {
            return (MyCloneableClass) super.clone();
        } catch (CloneNotSupportedException e) {
            // 1、因为实现了Cloneable接口所以不可能到这里
            throw new AssertionError();
        }
    }
}
