package _27_unchecked_warning;

import java.util.HashSet;
import java.util.Set;

public class UncheckWarning {
    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();
        strings.add("123");
        HashSet rawTypeSet = strings;
        // 原始类型转化为泛型，这种转化是危险的
        // 本来strings只能放String类型元素，现在变成了经过这部未检查的转化后
        // 变成了只能存放Integer类型的元素，最终打印的时候出错。
        Set<Integer> integers = rawTypeSet;
        integers.add(Integer.valueOf(1));
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
