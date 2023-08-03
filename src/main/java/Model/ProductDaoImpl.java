package Model;
import org.hibernate.query.NativeQuery;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    private final EntityManagerFactory emf;

    public ProductDaoImpl() {
        emf = Persistence.createEntityManagerFactory("tested");
    }


    @Override
    public void save(Product product) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Product findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Product person = em.find(Product.class, id);
        em.close();
        return person;
    }

    @Override
    public void update(Product product) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Product product) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(product) ? product : em.merge(product));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Product> findAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Product> typedQuery = em.createQuery("SELECT p FROM Product p", Product.class);
        List<Product> p = typedQuery.getResultList();
        em.getTransaction().commit();
        em.close();
        return p;
    }
}
