package kursovik.ProductUtils;

import kursovik.product.Coil;
import kursovik.product.CoilType;

import java.util.List;

/**
 * @author Ihor Solohub.
 */
public interface CoilDAO {
    void add(Coil coil);
    void delete (long[] ids);
    List<Coil> viewAll();
    List<Coil> viewSearched (String pattern);
    List<Coil> viewCoilsOfSelectedType(CoilType coilType);
    List<Coil> fromMinToMaxPrice();
    List<Coil> fromMaxToMinPrice();
    List<Coil> fromMinToMaxPriceByType(String coilType);
    List<Coil> fromMaxToMinPriceByType(String coilType);
}
