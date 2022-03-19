package _35_do_not_use_ordinal_but_property;

// Abuse of ordinal to derive an associated value - DON'T DO THIS
public enum Ensemble {
    SOLO, TRIO, QUARTET, QUINTET,
    SEXTET, SEPTET, OCTET, NONET, DECTET;

    // 直接使用ordinal的坏处在于：
    // 1、ordianl是顺序排序的，而且是根据顺序来的，又是这可能不是我们想要的
    public int numberOfMusicians() {
        return ordinal() + 1;
    }
}