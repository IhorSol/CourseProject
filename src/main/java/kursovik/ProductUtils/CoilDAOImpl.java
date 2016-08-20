package kursovik.ProductUtils;

import kursovik.product.Coil;
import kursovik.product.CoilType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Ihor Solohub.
 */
public class CoilDAOImpl implements CoilDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Coil coil) {
        entityManager.merge(coil);
    }

    @Override
    public void delete(long[] ids) {
        Coil c;
        for (long id:ids){
            c = entityManager.getReference(Coil.class, id);
            entityManager.remove(c);
        }
    }

    @Override
    public List viewAll() {
        Query query = entityManager.createQuery("SELECT c FROM Coil c", Coil.class);
        return (List<Coil>) query.getResultList();
    }

    @Override
    public List<Coil> viewSearched(String pattern) {
        Query query = entityManager.createQuery("SELECT c FROM Coil c WHERE c.name LIKE :pattern", Coil.class);
        query.setParameter("pattern", "%" + pattern + "%");
        if ((List<Coil>) query.getResultList()!= null) {
            return (List<Coil>) query.getResultList();
        } else return null;
    }

    @Override
    public List<Coil> viewCoilsOfSelectedType(CoilType coilType) {
        Query query = entityManager.createQuery("SELECT c FROM Coil c WHERE c.coilType = :coilType", Coil.class);
        if((List<Coil>) query.getResultList() !=null){
            return (List<Coil>) query.getResultList();
        } else return null;
    }

    @Override
    public List<Coil> fromMinToMaxPrice() {
        Query query = entityManager.createQuery("SELECT c FROM Coil c ORDER BY Price ASC", Coil.class);
        return (List<Coil>) query.getResultList();
    }

    @Override
    public List<Coil> fromMaxToMinPrice() {
        Query query = entityManager.createQuery("SELECT c FROM Coil c ORDER BY Price DESC", Coil.class);
        return (List<Coil>) query.getResultList();
    }

    @Override
    public List<Coil> fromMinToMaxPriceByType(String coilType) {
        Query query = entityManager.createQuery("SELECT c FROM Coil c WHERE c.coilType = :baitType ORDER BY Price ASC", Coil.class);
        return (List<Coil>) query.getResultList();
    }

    @Override
    public List<Coil> fromMaxToMinPriceByType(String coilType) {
        Query query = entityManager.createQuery("SELECT c FROM Coil c WHERE c.coilType = :baitType ORDER BY Price DESC", Coil.class);
        return (List<Coil>) query.getResultList();
    }
}
