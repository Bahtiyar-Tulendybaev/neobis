package neobis.week3.service;


import lombok.AllArgsConstructor;
import neobis.week3.dto.ProductDto;
import neobis.week3.entity.Product;
import neobis.week3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void AddNewProduct(ProductDto productDto) {
       Product product = new Product();
       product.setName(productDto.getName());
       product.setImage(productDto.getImage());
       product.setDescription(productDto.getDescription());
       product.setPrice(productDto.getPrice());
       productRepository.save(product);
    }

    public Product updateProductById(Long id,ProductDto productDto) throws Exception {
        return productRepository.findById(id)
                .map(updateProduct-> {
                    updateProduct.setName(productDto.getName());
                    updateProduct.setImage(productDto.getImage());
                    updateProduct.setDescription(productDto.getDescription());
                    updateProduct.setPrice(productDto.getPrice());
                    return productRepository.save(updateProduct);
                }).orElseThrow( Exception::new);
    }





}
