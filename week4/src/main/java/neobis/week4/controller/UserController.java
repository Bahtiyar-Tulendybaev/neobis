package neobis.week5.controller;

import neobis.week5.entity.User;

import neobis.week5.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
        @Autowired
        UserService customerService;


        @GetMapping(value="/all")
        public List<User> getAllCustomer() {

            return customerService.getAllCustomer();
        }

        @GetMapping("/{id}")
        public ResponseEntity<User> getCustomer(@PathVariable("id") Long id){

            return customerService.findById(id);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<User> deleteProduct(@PathVariable ("id") Long id){

            return customerService.deleteById(id);

        }

@PostMapping("/add")
    public String addUser(@RequestBody User user){
            customerService.addUser(user);
            return "User is added";

}

    }



