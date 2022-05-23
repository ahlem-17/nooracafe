package noora.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import noora.demo.Entity.Maker;

@Repository
public interface MakerRepository extends JpaRepository<Maker, Long>{
    
}
