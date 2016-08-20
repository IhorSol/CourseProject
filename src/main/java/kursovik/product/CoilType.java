package kursovik.product;

/**
 * @author Ihor Solohub
 */
public enum CoilType {
    MULTYPLIER_COIL ("Multiplier Coil"),
    INERTIALLESS_COIL ("InertialessCoil");

    private final String coilType;

    CoilType(String coilType) {
        this.coilType = coilType;
    }

    @Override
    public String toString() {
        return coilType;
    }
}
