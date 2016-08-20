package kursovik.ProductUtils;

import kursovik.product.Bait;
import kursovik.product.BaitType;
import kursovik.product.Coil;
import kursovik.product.Rod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Ihor Solohub.
 */
@Service
public class ProductService {
    @Autowired
    private BaitDAO baitDAO;
    @Autowired
    private CoilDAO coilDAO;
    @Autowired
    private RodDAO rodDAO;


                    /*------- Bait services -------*/
    @Transactional
    public void addBait (Bait bait){
        baitDAO.add(bait);
    }

    @Transactional
    public void deleteBait (long[] ids){
        baitDAO.delete(ids);
    }

    @Transactional(readOnly = true)
    public List<Bait> viewAllBaits (){
        return baitDAO.viewAll();
    }

    @Transactional(readOnly = true)
    public List<Bait> showSearchedBaits(String pattern){
        return baitDAO.viewSearched(pattern);
    }

    @Transactional(readOnly = true)
    public List<Bait> showBaitsByType(BaitType baitType){
        return baitDAO.viewBaitsOfSelectedType(baitType);
    }

    @Transactional(readOnly = true)
    public List<Bait> showBaitsFromMinToMaxPrice(){
        return baitDAO.fromMinToMaxPrice();
    }

    @Transactional(readOnly = true)
    public List<Bait> showBaitsFromMaxToMinPrice(){
        return baitDAO.fromMaxToMinPrice();
    }

    @Transactional(readOnly = true)
    public List<Bait> fromMinToMaxPriceByBaitType(String baitType){
        return baitDAO.fromMinToMaxPriceByType(baitType);
    }

    @Transactional(readOnly = true)
    public List<Bait> fromMaxToMinPriceByBaitType(String baitType){
        return baitDAO.fromMaxToMinPriceByType(baitType);
    }


                    /*------- Coil services -------*/
    @Transactional
    public void addCoil(Coil coil){
        coilDAO.add(coil);
    }

    @Transactional
    public void deleteCoil(long[] ids){
        coilDAO.delete(ids);
    }

    @Transactional(readOnly = true)
    public List<Coil> viewAllCoils(){
        return coilDAO.viewAll();
    }

    @Transactional(readOnly = true)
    public List<Coil> showSearchedCoils(String pattern){
        return coilDAO.viewSearched(pattern);
    }

    @Transactional(readOnly = true)
    public List<Coil> showCoilsFromMinToMaxPrice(){
        return coilDAO.fromMinToMaxPrice();
    }

    @Transactional(readOnly = true)
    public List<Coil> showCoilsFromMaxToMinPrice(){
        return coilDAO.fromMaxToMinPrice();
    }

    @Transactional(readOnly = true)
    public List<Coil> fromMaxToMinPrice(){
        return coilDAO.fromMaxToMinPrice();
    }

    @Transactional(readOnly = true)
    public List<Coil> fromMinToMaxPriceByCoilType(String coilType){
        return coilDAO.fromMinToMaxPriceByType(coilType);
    }

    @Transactional(readOnly = true)
    public List<Coil> fromMaxToMinPriceByCoilType(String coilType){
        return coilDAO.fromMaxToMinPriceByType(coilType);
    }


                    /*------- Rod services -------*/
    @Transactional
    public void addRod(Rod rod){
        rodDAO.add(rod);
    }

    @Transactional
    public void deleteRod(long[] ids){
        rodDAO.delete(ids);
    }

    @Transactional(readOnly = true)
    public List<Rod> viewAllRods(){
        return rodDAO.viewAll();
    }

    @Transactional(readOnly = true)
    public List<Rod> showSearchedRods(String pattern){
        return rodDAO.viewSearched(pattern);
    }

    @Transactional(readOnly = true)
    public List<Rod> showRodsFromMinToMaxPrice(){
        return rodDAO.fromMinToMaxPrice();
    }

    @Transactional(readOnly = true)
    public List<Rod> showRodsFromMaxToMinPrice(){
        return rodDAO.fromMaxToMinPrice();
    }

    @Transactional(readOnly = true)
    public List<Rod> fromMinToMaxPriceByRodType(String rodType){
        return rodDAO.fromMinToMaxPriceByType(rodType);
    }

    @Transactional(readOnly = true)
    public List<Rod> fromMaxToMinPriceByRodType(String rodType){
        return rodDAO.fromMaxToMinPriceByType(rodType);
    }
}
