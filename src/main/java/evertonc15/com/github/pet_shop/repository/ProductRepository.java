package evertonc15.com.github.pet_shop.repository;

import evertonc15.com.github.pet_shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByDescriptionAndMaker(String description, String maker);
    boolean existsByDescriptionAndMakerAndIdNot(String description, String maker, Long id);
    List<Product> findByActiveTrue();

}
