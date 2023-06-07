package lgda.manager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product, Long id) {
        Product foundProduct = getProductById(id);

        foundProduct.setName(product.getName());
        foundProduct.setDescription(product.getDescription());
        foundProduct.setThumbnail(product.getThumbnail());
        foundProduct.setIsDiscounted(product.getIsDiscounted());
        foundProduct.setIsAvailable(product.getIsAvailable());
        foundProduct.setPrice(product.getPrice());
        foundProduct.setDiscountPercent(product.getDiscountPercent());

        return productRepository.save(foundProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
