package dependency_injection;

import java.util.Collections;
import java.util.List;

public class SpellChecker {
    private final Lexicon dictionary;

    // 通过依赖注入资源，可以增强类的灵活性和可测试性
    // 1、灵活性，用户通过注入不同的字典就可以实现不同语言的SpellChecker
    //    联想到普通工厂方法也可以直接注入，而不是自己直接new！！
    // 2、可测试性，我们可以注入一个Mock之后的字典类
    // 3、在构造器中注入而不是setter中注入的好处，减少并行可能带来的错误
    // 4、静态工具类和单例类不适合与需要引用底层资源的类？？
    public SpellChecker(Lexicon dictionary) {
        this.dictionary = dictionary;
    }

    public boolean isValid(String word) {
        return true;
    }

    public List<String> suggestions(String typo) {
        return Collections.emptyList();
    }
}
