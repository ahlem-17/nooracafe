package noora.demo.Entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product extends AbstractPersistable<Long> {

   

    private String name;

    private String description;

    private Double price;

    private String image;

    @ManyToOne()
    @JoinColumn(name = "departement_id", nullable = false)
    private Departement departement;
}
