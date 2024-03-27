package neobis.week4.controller;


import neobis.week4.dto.AuthenticationResponse;
import neobis.week4.dto.LoginRequest;
import neobis.week4.dto.RegisterRequest;
import neobis.week4.entity.User;

import neobis.week4.exception.UserAlreadyExistsException;
import neobis.week4.exception.UserNotFoundException;
import neobis.week4.service.UserService;

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
public ResponseEntity<?> register(@RequestBody RegisterRequest request){
    try {
        customerService.register(request);
    }catch (UserAlreadyExistsException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    return ResponseEntity.ok().build();
}


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        AuthenticationResponse authenticationResponse;
        try {
            authenticationResponse = customerService.login(request);
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(authenticationResponse);
    }

    }



