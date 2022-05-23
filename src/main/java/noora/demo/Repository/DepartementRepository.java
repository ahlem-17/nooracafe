package noora.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import noora.demo.Entity.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
    
}
