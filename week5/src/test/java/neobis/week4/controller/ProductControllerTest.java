package neobis.week4.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import neobis.week4.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MockMvc mockMvc;





    @Test
    void canGetAllProduct() throws Exception {
        mockMvc.perform(
                        get("/api/v1/products/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void canGetProductById() throws Exception {
        mockMvc.perform(
                        get("/api/v1/products/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void canCreateProduct() throws Exception {
        Product product = new Product();
        product.setName("Samsung Galaxy S20");
        product.setImage("Samsung.png");
        product.setDescription("Samsung is mobile phone");
        product.setPrice(500);
        String jsonRequest = mapper.writeValueAsString(product);
        mockMvc.perform(
                        post("/api/v1/products/add")
                                .content(jsonRequest)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }




}