package lgda.manager.orderCart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lgda.manager.product.Product;
import lgda.manager.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name = "user")
    private User user;

    private Integer orderNumber;
    private Float totalCost;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JsonIgnoreProperties("orderCartList")
    private Set<Product> productList = new HashSet<>();

    //@CreationTimestamp
    //private Instant creationDate;

    private String creationDate;
    private OrderStatus orderStatus;

}
