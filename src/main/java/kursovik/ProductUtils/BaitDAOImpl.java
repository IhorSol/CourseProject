package kursovik.ProductUtils;

import kursovik.product.Bait;
import kursovik.product.BaitType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Ihor Solohub.
 */
@Repository
public class BaitDAOImpl implements BaitDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Bait bait) {
        entityManager.merge(bait);
    }

    @Override
    public void delete(long[] ids) { // видалення групи наживок або одного елемента
        Bait b;
        for (long id:ids){
            b = entityManager.getReference(Bait.class, id);
            entityManager.remove(b);
        }
    }

    @Override
    public List<Bait> viewAll() {
        Query query = entityManager.createQuery("SELECT b FROM Bait b", Bait.class);
        return (List<Bait>) query.getResultList();
    }

    @Override
    public List<Bait> viewSearched(String pattern) {
        Query query = entityManager.createQuery("SELECT b FROM Bait b WHERE b.name LIKE :pattern", Bait.class);
        query.setParameter("pattern", "%" + pattern + "%");
        if((List<Bait>) query.getResultList() !=null){
            return (List<Bait>) query.getResultList();
        } else return null;   // треба покращити. Може шось буде виводить, якесь повідомлення
    }

    @Override
    public List<Bait> viewBaitsOfSelectedType(BaitType baitType) {
        Query query = entityManager.createQuery("SELECT b FROM Bait b WHERE b.baitType = :baitType", Bait.class);
        if((List<Bait>) query.getResultList() !=null){
            return (List<Bait>) query.getResultList();
        } else return null;
    }

    @Override
    public List<Bait> fromMinToMaxPrice() {
        Query query = entityManager.createQuery("SELECT b FROM Bait b ORDER BY Price ASC", Bait.class);
        return (List<Bait>) query.getResultList();
    }

    @Override
    public List<Bait> fromMaxToMinPrice() {
        Query query = entityManager.createQuery("SELECT b FROM Bait b ORDER BY Price DESC", Bait.class);
        return (List<Bait>) query.getResultList();
    }

    @Override
    public List<Bait> fromMinToMaxPriceByType(String baitType) {
        Query query = entityManager.createQuery("SELECT b FROM Bait b WHERE b.baitType = :baitType ORDER BY Price ASC", Bait.class);
        return (List<Bait>) query.getResultList();
    }

    @Override
    public List<Bait> fromMaxToMinPriceByType(String baitType) {
        Query query = entityManager.createQuery("SELECT b FROM Bait b WHERE b.baitType = :baitType ORDER BY Price DESC", Bait.class);
        return (List<Bait>) query.getResultList();
    }

}
