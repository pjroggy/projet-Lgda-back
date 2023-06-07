package lgda.manager.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lgda.manager.category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String thumbnail;
    private Boolean isDiscounted;
    private Boolean isAvailable;
    private Float price;
    private Float discountPercent;

    @ManyToOne
    @JsonIgnoreProperties("productList")
    private Category category;
}
