package noora.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import noora.demo.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByDepartement_Id(Long id);
    
}
