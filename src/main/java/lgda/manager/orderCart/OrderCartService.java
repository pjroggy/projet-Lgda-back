package lgda.manager.orderCart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderCartService {

    private final OrderCartRepository orderCartRepository;

    public List<OrderCart> getAllOrderCart() {
        return orderCartRepository.findAll();
    }

    public OrderCart getOrderCartById(Long id) {
        return orderCartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
    }

    public OrderCart addOrderCart(OrderCart orderCart) {
        return orderCartRepository.save(orderCart);
    }

    public OrderCart updateOrderCart(OrderCart orderCart, Long id) {
        OrderCart foundOrderCart = getOrderCartById(id);

        foundOrderCart.setUser(orderCart.getUser());
        foundOrderCart.setOrderNumber(orderCart.getOrderNumber());
        foundOrderCart.setTotalCost(orderCart.getTotalCost());
        foundOrderCart.setCreationDate(orderCart.getCreationDate());
        foundOrderCart.setOrderStatus(orderCart.getOrderStatus());

        return orderCartRepository.save(foundOrderCart);
    }

    public void deleteOrderCart(Long id) {
        orderCartRepository.deleteById(id);
    }
}
