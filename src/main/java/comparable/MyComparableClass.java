package comparable;

import clone.MyCloneableClass;

import java.util.Comparator;

public class MyComparableClass implements Comparable<MyComparableClass>{
    private int filed1;
    private int filed2;

    // 1、实现方式1
    @Override
    public int compareTo(MyComparableClass o) {
        int result = Integer.compare(filed1, o.filed1);
        if (result != 0) {
            return result;
        }

        return Integer.compare(filed2, o.filed2);
    }

    // 2、实现方式2
//    private static final Comparator<MyComparableClass> COMPARATOR =
//            Comparator.comparingInt((MyComparableClass o) -> o.filed1)
//                      .thenComparingInt((MyComparableClass o) -> o.filed2);
//    @Override
//    public int compareTo(MyComparableClass o) {
//        return COMPARATOR.compare(this, o);
//    }


}
