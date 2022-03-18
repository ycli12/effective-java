package _28_prefer_list_rather_array;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PerferListRatherArray {
    public static void main(String[] args) {
        // 1、数组是协变的，而泛型是不变的，这可能存在一些问题
        Object[] objects = new Long[1];
        objects[0] = "123"; // 运行时报错

//        List<Object> objects1 = new LinkedList<Long>(); // 编译时报错
//        objects1.add("123");



        // 2、数组是具体的类型
        // 无法创建new List<E>[]、new List<String>[]、new E[]等类型


//        // 3、为什么创建一个泛型数组是非法的？
//        // 数组的协变会破坏泛型的不变
//        List<String>[] lists = new List<String>[1]; // 如果可以创建泛型数组
//        List<Integer> intList = Collections.singletonList(42);
//        Object[] objects2 = lists; // 数组协变
//        objects2[0] = intList; // 类型改变
//        String s = lists[0].get(0); // 运行时出错


    }
}
