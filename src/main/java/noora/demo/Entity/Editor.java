package noora.demo.Entity;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Editor extends AbstractPersistable<Long>{
    
    private String name;
    private String editorPerson;
    private String contactEmail;
}
