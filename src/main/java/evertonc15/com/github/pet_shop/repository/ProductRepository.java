package evertonc15.com.github.pet_shop.repository;

import evertonc15.com.github.pet_shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByDescriptionAndMaker(String description, String maker);

}
