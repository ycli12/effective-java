package builder;

public class NutritionFacts {
    // 3、所有参数都可以设置为final，JavaBean+setter的做法不能做到
    private final int servingSize; // required
    private final int servings; // required
    private final int categories; // optional

    private NutritionFacts(int servingSize, int servings, int categories) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.categories = categories;
    }

    public int getServingSize() {
        return servingSize;
    }

    public int getServings() {
        return servings;
    }

    public int getCategories() {
        return categories;
    }

    public static class NutritionFactsBuilder {
        private final int servingSize; // required
        private final int servings; // required
        private int categories = 0; // optional，后面需要通过categories方法设置，所以没有加final

        public NutritionFactsBuilder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public NutritionFactsBuilder categories(int categories) {
            this.categories = categories;
            return this;
        }

        public NutritionFacts build() {
            // 2、参数校验简单
            if (servingSize < 0) {
                throw new IllegalArgumentException("输入的参数servingSize有误！");
            }

            // 4、保持对象内部状态的一致性，不会每次setter搞一次！
            return new NutritionFacts(servingSize, servings, categories);
        }
    }
}
