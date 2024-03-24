package neobis.week4.service;


import lombok.AllArgsConstructor;

import neobis.week4.dto.ProductDto;
import neobis.week4.entity.Product;
import neobis.week4.exception.ResourceNotFoundException;
import neobis.week4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<Product> findById(Long id) {

        Product product = productRepository.findById(id)
         .orElseThrow(() -> new ResourceNotFoundException("Product was not found"));
        return ResponseEntity.ok(product);
    }

    public ResponseEntity<Product> deleteById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product was not found"));
        productRepository.deleteById(id);

       return ResponseEntity.ok(product);
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
                }).orElseThrow(() -> new ResourceNotFoundException("Product was not found"));
    }





}
