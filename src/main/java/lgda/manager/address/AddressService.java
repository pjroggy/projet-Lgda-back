package lgda.manager.address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
    }

    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Address address, Long id) {
        Address foundAddress = getAddressById(id);

        foundAddress.setNumberAndStreetName(address.getNumberAndStreetName());
        foundAddress.setZipcode(address.getZipcode());
        foundAddress.setCity(address.getCity());

        return addressRepository.save(foundAddress);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
