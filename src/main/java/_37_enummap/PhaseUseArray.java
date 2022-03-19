package _37_enummap;

// Using ordinal() to index array of arrays - DON'T DO THIS!
public enum PhaseUseArray {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;
        // Rows indexed by from-ordinal, cols by to-ordinal
        // 一旦新增新的状态，那么修改的东西比较多
        private static final Transition[][] TRANSITIONS = {
                {null, MELT, SUBLIME},
                {FREEZE, null, BOIL},
                {DEPOSIT, CONDENSE, null}
        };

        // Returns the phase transition from one phase to another
        public static Transition from(PhaseUseArray from, PhaseUseArray to) {
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }
}
