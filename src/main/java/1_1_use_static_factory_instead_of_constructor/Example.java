import java.math.BigInteger;
import java.util.Random;

public class Example {
    public static void main(String[] args) {
        // 1. 简单示例
        Boolean aBoolean = Boolean.valueOf(true);
        System.out.println(aBoolean);

        // 2.有名字更加清晰，通过名字可以直接看出来它是获取素数的，构造器永远都是跟类名一样
        BigInteger probablePrime = BigInteger.probablePrime(5, new Random());
        System.out.println(probablePrime);

        // 3.不必在每次调用它们的时候都创建一个新对象，类似于FlyWeight
        // 静态方法可以严格控制创建的实例，比如Singleton、不可实例化、不可变类（枚举类型）
        Boolean aBoolean1 = Boolean.valueOf(true);
        System.out.println(aBoolean1);

        // 4.可以返回子类
        

    }
}
