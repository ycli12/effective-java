package _37_enummap;

import _34_enum.Planet;
import com.sun.javafx.logging.JFRInputEvent;

import java.util.*;

class Plant {
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Plant[] plants = {
                new Plant("A1", LifeCycle.ANNUAL),
                new Plant("B1", LifeCycle.PERENNIAL),
                new Plant("C1", LifeCycle.BIENNIAL),
                new Plant("A2", LifeCycle.ANNUAL),
                new Plant("B2", LifeCycle.PERENNIAL),
                new Plant("C2", LifeCycle.BIENNIAL),
        };

        // 1、数组类型不兼容泛型
        // 2、访问plantsByLifeCycle的时候必须保证不会抛出数组越界异常
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }

        for (Plant plant : plants) {
            plantsByLifeCycle[plant.lifeCycle.ordinal()].add(plant);
        }

        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }

        // 1、不用数组的强制类型转化
        EnumMap<LifeCycle, Set<Plant>> lifeCycleSetEnumMap = new EnumMap<>(Plant.LifeCycle.class);
        for (LifeCycle lc : LifeCycle.values()) {
            lifeCycleSetEnumMap.put(lc, new HashSet<>());
        }
        for (Plant plant : plants) {
            // 3、跟数组一样快，因为内部使用了一个数组
            lifeCycleSetEnumMap.get(plant.lifeCycle).add(plant);
        }
        // 2、自动输出
        System.out.println(lifeCycleSetEnumMap);
    }
}