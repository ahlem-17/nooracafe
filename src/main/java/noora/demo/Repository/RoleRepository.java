package noora.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import noora.demo.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
    
}
