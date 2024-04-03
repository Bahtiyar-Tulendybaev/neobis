package neobis.week4.controller;
import neobis.week4.dto.ProductDto;
import neobis.week4.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired ProductController productController;


    @Test
    void canGetAllProduct() {
        ResponseEntity<?> responseEntity = productController.getAllProduct();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void canGetProductById() {
        ResponseEntity<?> responseEntity = productController.getProduct(2l);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void canCreateProduct() {
        ProductDto product = new ProductDto();
        product.setName("Samsung Galaxy S21");
        product.setImage("Samsung.png");
        product.setDescription("Samsung is mobile phone");
        product.setPrice(500);
        ResponseEntity<?> responseEntity = productController.addProduct(product);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }


    @Test
    void deleteProductById(){
        ResponseEntity<Product> product = productController.deleteProduct(2l);
        assertEquals(HttpStatus.OK, product.getStatusCode());
    }

}