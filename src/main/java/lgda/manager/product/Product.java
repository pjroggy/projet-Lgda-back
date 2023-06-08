package lgda.manager.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lgda.manager.category.Category;
import lgda.manager.orderCart.OrderCart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "productList")
    @JsonIgnoreProperties("productList")
    private Set<OrderCart> orderCartList = new HashSet<>();
}
