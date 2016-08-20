package kursovik.product;

/**
 * @author Ihor Solohub
 */
public enum RodType {
    SPINNING("Spinning"),
    FEEDER("Feeder"),
    FISHING_ROD("Fishing rod");

    private final String rodType;

    RodType(String rodType) {
        this.rodType = rodType;
    }

    @Override
    public String toString() {
        return rodType;
    }
}
