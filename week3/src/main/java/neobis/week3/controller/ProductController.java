package neobis.week3.controller;

import neobis.week3.dto.ProductDto;
import neobis.week3.entity.Product;
import neobis.week3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;


    @GetMapping(value="/all")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") Long id){
        return productService.findById(id);
    }


    @PostMapping("/add")
    public ProductDto addProduct(@RequestBody ProductDto product) {
        productService.AddNewProduct(product);
        return product;

    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable ("id") Long id){
        productService.deleteById(id);
        return " successfully deleted!";
    }



    @PutMapping("/{id}")
    public Product putProduct(@PathVariable ("id") Long id ,@RequestBody ProductDto productDto) throws Exception {
        return productService.updateProductById(id,productDto);
    }


}


