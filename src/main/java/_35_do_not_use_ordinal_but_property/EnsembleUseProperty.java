package _35_do_not_use_ordinal_but_property;

public enum EnsembleUseProperty {
    SOLO(1), DUET(2),
    TRIO(3),QUARTET(4),
    QUINTET(5),
    SEXTET(6),SEPTET(7),
    OCTET(8),DOUBLE_QUARTET(8),
    NONET(9),DECTET(10),
    TRIPLE_QUARTET(12);

    private final int numberOfMusicians;

    EnsembleUseProperty(int size) {
        this.numberOfMusicians = size;
    }

    public int numberOfMusicians() {
        return numberOfMusicians;
    }
}
