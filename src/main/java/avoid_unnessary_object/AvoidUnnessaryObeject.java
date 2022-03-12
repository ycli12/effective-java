package avoid_unnessary_object;

import java.util.HashMap;
import java.util.regex.Pattern;

public class AvoidUnnessaryObeject {
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    public static void main(String[] args) {
        // 1、String是不可变的，不要这样每次创建一个新的字符串对象
        String s1 = new String("123");

        // 2、直接这样赋值即可
        String s2 = "123";

        // 3、使用静态工厂方法可以减少部分不必要的对象
        Boolean aBoolean = Boolean.valueOf(true);

        // 5、keySet每次都返回相同的对象，而不是每次创建一个对象
        HashMap<String, String> map = new HashMap<String, String>();
        map.keySet();

        // 7、必要的对象还是要创建的

        // 8、维护对象池会使得代码混乱、增加内存占用，并损害性能

    }

    // 4、避免重复的创建类可能意味着避免重复的计算，比如Pattern
    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }

    // 6、不必要的拆装箱，优先使用基本类型而不是装箱的基本类型
    private static long sum() {
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }
}
