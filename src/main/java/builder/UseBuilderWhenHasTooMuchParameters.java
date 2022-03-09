package builder;

import org.junit.Assert;
import org.junit.Test;

import static builder.NyPizza.Size.SMALL;
import static builder.Pizza.Topping.*;
import static org.junit.Assert.*;

public class UseBuilderWhenHasTooMuchParameters {
    private static final int SERVING_SIZE = 1;
    private static final int SERVINGS = 2;
    private static final int CATEGORIES = 3;

    public static void main(String[] args) {
        // 1、参数简明，不用一大堆一个个对齐
        NutritionFacts nutritionFacts = new NutritionFacts
                .NutritionFactsBuilder(SERVING_SIZE, SERVINGS)
                .categories(CATEGORIES)
                .build();

        Assert.assertEquals(SERVING_SIZE, nutritionFacts.getServingSize());
        Assert.assertEquals(SERVINGS, nutritionFacts.getServings());
        Assert.assertEquals(CATEGORIES, nutritionFacts.getCategories());

        // 2、
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();


    }
}
