package neobis.week4.controller;
import lombok.AllArgsConstructor;
import neobis.week4.dto.CustomerDto;
import neobis.week4.service.AuthUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/registration")
public class RegistrationController {
    private final AuthUserDetailsService authUserDetailsService;
    @PostMapping
    ResponseEntity<?> customerRegistration(@RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(authUserDetailsService.registration(customerDto),HttpStatus.OK);


    }


}
