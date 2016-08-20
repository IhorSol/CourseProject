package kursovik.ProductUtils;

import kursovik.product.Bait;
import kursovik.product.BaitType;

import java.util.List;

/**
 * @author Ihor Solohub.
 */
public interface BaitDAO {
    void add (Bait bait);
    void delete (long[] ids);
    List<Bait> viewAll();
    List<Bait> viewSearched(String pattern);
    List<Bait> viewBaitsOfSelectedType(BaitType baitType);
    List<Bait> fromMinToMaxPrice();
    List<Bait> fromMaxToMinPrice();
    List<Bait> fromMinToMaxPriceByType(String baitType);
    List<Bait> fromMaxToMinPriceByType(String baitType);
}
