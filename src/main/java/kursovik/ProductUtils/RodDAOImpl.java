package kursovik.ProductUtils;

import kursovik.product.Coil;
import kursovik.product.Rod;
import kursovik.product.RodType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Ihor Solohub.
 */
public class RodDAOImpl implements RodDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Rod rod) {
        entityManager.merge(rod);
    }

    @Override
    public void delete(long[] ids) {
        Rod r;
        for (long id:ids){
            r = entityManager.getReference(Rod.class, id);
            entityManager.remove(r);
        }
    }

    @Override
    public List<Rod> viewAll() {
        Query query = entityManager.createQuery("SELECT r FROM Rod r", Rod.class);
        return (List<Rod>) query.getResultList();
    }

    @Override
    public List<Rod> viewSearched(String pattern) {
        Query query = entityManager.createQuery("SELECT r FROM Rod r WHERE r.name LIKE :pattern", Rod.class);
        query.setParameter("pattern", "%" + pattern + "%");
        if ((List<Rod>) query.getResultList()!= null) {
            return (List<Rod>) query.getResultList();
        } else return null;
    }

    @Override
    public List<Rod> viewRodsOfSelectedType(RodType rodType) {
        Query query = entityManager.createQuery("SELECT r FROM Rod r WHERE r.rodType = :rodType", Rod.class);
        if((List<Rod>) query.getResultList() !=null){
            return (List<Rod>) query.getResultList();
        } else return null;
    }

    @Override
    public List<Rod> fromMinToMaxPrice() {
        Query query = entityManager.createQuery("SELECT r FROM Rod r ORDER BY Price ASC", Rod.class);
        return (List<Rod>) query.getResultList();
    }

    @Override
    public List<Rod> fromMaxToMinPrice() {
        Query query = entityManager.createQuery("SELECT r FROM Rod r ORDER BY Price DESC", Rod.class);
        return (List<Rod>) query.getResultList();
    }

    @Override
    public List<Rod> fromMinToMaxPriceByType(String rodType) {
        Query query = entityManager.createQuery("SELECT r FROM Rod r WHERE r.rodType = :rodType ORDER BY Price ASC", Rod.class);
        return (List<Rod>) query.getResultList();
    }

    @Override
    public List<Rod> fromMaxToMinPriceByType(String coilType) {
        Query query = entityManager.createQuery("SELECT r FROM Rod r WHERE r.rodType = :rodType ORDER BY Price DESC", Rod.class);
        return (List<Rod>) query.getResultList();
    }
}
