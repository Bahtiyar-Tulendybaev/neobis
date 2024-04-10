package neobis.week5.controller;


import neobis.week5.dto.ProductDto;
import neobis.week5.entity.Product;
import neobis.week5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;


    @GetMapping(value="/all")

    public ResponseEntity<?> getAllProduct() {
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Long id){
        return ResponseEntity.ok().body( productService.findById(id));
    }


    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto product) {
        productService.AddNewProduct(product);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable ("id") Long id){
        return productService.deleteById(id);

    }



    @PutMapping("/{id}")
    public Product putProduct(@PathVariable ("id") Long id ,@RequestBody ProductDto productDto) throws Exception {
        return productService.updateProductById(id,productDto);
    }


}


