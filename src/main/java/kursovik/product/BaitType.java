package kursovik.product;

/**
 * @author Ihor Solohub
 */
public enum BaitType {
    WOBBLER ("Wobbler"),
    SPOON ("Spoon"),
    SILICON ("Silicon");

    private final String baitType;

    BaitType(String baitType){
    this.baitType = baitType;
}

    @Override
    public String toString() {
        return baitType;
    }
}
