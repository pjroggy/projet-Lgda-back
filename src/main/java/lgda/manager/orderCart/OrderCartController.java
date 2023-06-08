package lgda.manager.orderCart;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderCartController {

    private final OrderCartService orderCartService;

    @GetMapping
    public List<OrderCart> getAllOrderCart() {
        return orderCartService.getAllOrderCart();}
    @GetMapping("/{id}")
    public OrderCart getOrderCartById(@PathVariable("id") Long id) {
        return  orderCartService.getOrderCartById(id);
    }
    @PostMapping("/add")
    public OrderCart addOrderCart(@RequestBody OrderCart orderCart) {
        return orderCartService.addOrderCart(orderCart);
    }

    @PutMapping("/update/{id}")
    public OrderCart updateOrderCart(@RequestBody OrderCart orderCart, @PathVariable("id") Long id) {
        return orderCartService.updateOrderCart(orderCart, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrderCart(@PathVariable("id") Long id) { orderCartService.deleteOrderCart(id);}

}
