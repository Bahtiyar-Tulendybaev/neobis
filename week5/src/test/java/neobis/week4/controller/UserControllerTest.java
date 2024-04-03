package neobis.week4.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import neobis.week4.dto.Login;
import neobis.week4.entity.Role;
import neobis.week4.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    UserController userController;



    @Test
    void canGetAllUsers(){
        ResponseEntity<?> responseEntity = userController.getAllCustomer();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }


    @Test

    void canGetUserById(){
        ResponseEntity<?> responseEntity = userController.getCustomer(2l);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void canCreateUser() throws Exception {
        User user = new User();
        user.setName("User5");
        user.setPassword("123");
        user.setRole(Role.USER);
        String jsonRequest = mapper.writeValueAsString(user);
        mockMvc.perform(
                        post("/api/v1/users/add")
                                .content(jsonRequest)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void login() {
        Login login = new Login("User5", "123");
        ResponseEntity<?> responseEntity = userController.login(login);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }




}