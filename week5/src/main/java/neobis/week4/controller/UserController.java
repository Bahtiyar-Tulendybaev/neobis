package neobis.week4.controller;


import neobis.week4.dto.AuthResponse;
import neobis.week4.dto.Login;
import neobis.week4.dto.Register;
import neobis.week4.exception.UserAlreadyExistsException;
import neobis.week4.exception.UserNotFoundException;
import neobis.week4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
        @Autowired
        UserService customerService;


        @GetMapping(value="/all")
        public ResponseEntity<?> getAllCustomer() {

            return ResponseEntity.ok().body(customerService.getAllCustomer());
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> getCustomer(@PathVariable("id") Long id){

           return ResponseEntity.ok().body(customerService.findById(id));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteUser(@PathVariable ("id") Long id){

            return ResponseEntity.ok().body(customerService.deleteById(id));

        }

@PostMapping("/add")
public ResponseEntity<?> register(@RequestBody Register request){
    try {
        customerService.register(request);
    }catch (UserAlreadyExistsException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    return ResponseEntity.ok().build();
}


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login request){
        AuthResponse authResponse;
        try {
            authResponse = customerService.login(request);
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(authResponse);
    }

    }



