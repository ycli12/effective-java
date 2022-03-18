package _28_prefer_list_rather_array;

import java.util.Collection;
import java.util.Collections;

public class Chooser<T> {
    private final T[] choiceArray;

    public Chooser(Collection<T> choices) {
        // 不会报错，但会产生未检查告警，这里我们能保证choices.toArray()的结果就是T[]
        // 因此我们可以用@SuppressWarning注解
        choiceArray = (T[]) choices.toArray();
    }
}
