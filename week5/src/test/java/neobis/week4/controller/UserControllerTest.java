package neobis.week4.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import neobis.week4.entity.Role;
import neobis.week4.entity.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;



    @Test
    @Order(8)
    void canGetAllUsers() throws Exception {
        mockMvc.perform(
                        get("/api/v1/users/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    @Order(3)
    void canGetUserById() throws Exception {
        mockMvc.perform(
                        get("/api/v1/users/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void canCreateUser() throws Exception {
        User user = new User();
        user.setName("User1");
        user.setPassword("123");
        user.setRole(Role.USER);
        String jsonRequest = mapper.writeValueAsString(user);
        mockMvc.perform(
                        post("/api/v1/users/add")
                                .content(jsonRequest)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }






}