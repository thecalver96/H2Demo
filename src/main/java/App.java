import Model.Product;
import Model.ProductDao;
import Model.ProductDaoImpl;
import lombok.extern.log4j.Log4j;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoImpl();

        Product p1 = Product.builder()

                .expiration(LocalDate.now())
                .name("ElsoValami")
                .pieces(1)
                .registered(LocalDate.now())
                .weight(34.1)
                .build();
    productDao.save(p1);

        Product p2 = Product.builder()

                .expiration(LocalDate.now())
                .name("MasodikValami")
                .pieces(1)
                .registered(LocalDate.now())
                .weight(34.1)
                .build();
        productDao.save(p2);
        System.out.println(productDao.findAll());
    }
}
