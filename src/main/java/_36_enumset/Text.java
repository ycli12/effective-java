package _36_enumset;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Text {
    public enum Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
    }

    public void appleStyles(Set<Style> styles) {
        String styleString = styles
                            .stream()
                            .map(style -> style.toString())
                            .collect(Collectors.joining(","));
        System.out.println(styleString);
    }

    public static void main(String[] args) {
        Text text = new Text();
        // 这里使用EnumSet代替那些位域运算
        text.appleStyles(EnumSet.of(Style.BOLD, Style.UNDERLINE));
    }
}
