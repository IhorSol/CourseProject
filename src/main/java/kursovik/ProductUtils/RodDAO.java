package kursovik.ProductUtils;

import kursovik.product.Rod;
import kursovik.product.RodType;

import java.util.List;

/**
 * @author Ihor Solohub.
 */
public interface RodDAO {
    void add(Rod rod);
    void delete(long[] ids);
    List<Rod> viewAll();
    List<Rod> viewSearched(String pattern);
    List<Rod> viewRodsOfSelectedType(RodType rodType);
    List<Rod> fromMinToMaxPrice();
    List<Rod> fromMaxToMinPrice();
    List<Rod> fromMinToMaxPriceByType(String coilType);
    List<Rod> fromMaxToMinPriceByType(String coilType);
}
