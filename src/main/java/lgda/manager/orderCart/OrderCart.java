package lgda.manager.orderCart;

import jakarta.persistence.*;
import lgda.manager.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name = "user_id")
    private User user;

    private Integer orderNumber;
    private Integer totalCost;

    @CreationTimestamp
    private Instant creationDate;

    private OrderStatus orderStatus;

}
