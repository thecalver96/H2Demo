package Model;

import java.util.List;

public interface ProductDao {

    void save(Product product);

    Product findById(Long id);

    void update(Product product);

    void delete(Product product);

    List<Product> findAll();
}
