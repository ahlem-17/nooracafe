package noora.demo.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import javax.persistence.*;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departement extends AbstractPersistable<Long>{



    private String name;

    private Long departementId;
    

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departement")
    private Set<Product> product;
}
