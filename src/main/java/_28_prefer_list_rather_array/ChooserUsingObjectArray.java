package _28_prefer_list_rather_array;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserUsingObjectArray {
    // 由于不能创建泛型数组，因此只能用Object数组Object[]
    private final Object[] choiceArray;

    public ChooserUsingObjectArray(Collection choices) {
        choiceArray = choices.toArray();
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
