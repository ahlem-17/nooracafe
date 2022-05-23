package noora.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import noora.demo.Entity.Editor;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Long>{
    
}
