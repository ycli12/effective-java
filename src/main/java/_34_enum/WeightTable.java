package _34_enum;

public class WeightTable {
    public static void main(String[] args) {
        // values方法
        double earthWeight = Double.parseDouble("123");
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
        }

        // valueOf
        System.out.println(Planet.valueOf("MERCURY"));
//        System.out.println(Planet.valueOf("123"));

        // compareTo
        System.out.println(Planet.EARTH.compareTo(Planet.MERCURY));

        //
    }
}
