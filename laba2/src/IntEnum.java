/**
 * @author Maria Dron
 */
public enum IntEnum {
    ZERO(0), ONE(1), TWO(2), THREE(3);
    private final int value;

    private IntEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public IntEnum copmareValue(int value) {
        switch (value) {
            case 0:
                return ZERO;
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            default:
                return null;
        }
    }
}
