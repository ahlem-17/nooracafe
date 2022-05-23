package noora.demo.Entity;




import lombok.Data;


@Data
public class ProductDTO{

    private Long id;
    
    private String name;

    private String description;

    private Double price;

    private String image;

    private Long departementId;
}
