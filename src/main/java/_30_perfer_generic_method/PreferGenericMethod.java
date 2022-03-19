package _30_perfer_generic_method;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PreferGenericMethod {
    // 使用原始类型的方法，会产生两个告警
    public static Set union1(Set s1, Set s2) {
        HashSet result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    // 泛型方法：
    // 1、不会产生告警
    // 2、不必强制类型转化
    public static <E> Set<E> union2(Set<E> s1, Set<E> s2) {
        HashSet<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
}
