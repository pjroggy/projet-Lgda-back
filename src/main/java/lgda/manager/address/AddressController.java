package lgda.manager.address;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public List<Address> getAllAddress() {
        return addressService.getAllAddress();}
    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable("id") Long id) {
        return  addressService.getAddressById(id);
    }
    @PostMapping("/add")
    public Address addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @PutMapping("/update/{id}")
    public Address updateAddress(@RequestBody Address address, @PathVariable("id") Long id) {
        return addressService.updateAddress(address, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable("id") Long id) { addressService.deleteAddress(id);}

}
