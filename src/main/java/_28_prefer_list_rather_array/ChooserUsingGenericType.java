package _28_prefer_list_rather_array;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserUsingGenericType<T> {
    private final List<T> choiceList;

    public ChooserUsingGenericType(Collection<T> choices) {
        this.choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
