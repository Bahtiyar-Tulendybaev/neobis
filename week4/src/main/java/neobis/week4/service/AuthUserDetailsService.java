package neobis.week4.service;
import lombok.RequiredArgsConstructor;
import neobis.week4.dto.CustomerDto;
import neobis.week4.dto.Response;
import neobis.week4.entity.Customer;
import neobis.week4.repository.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;




@Service
@RequiredArgsConstructor
public class AuthUserDetailsService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder encoder;







    public Response registration(CustomerDto customerDto) {
        Customer customer = new Customer();
                customer.setName(customerDto.getName());
                customer.setEmail(customerDto.getEmail());
                customer.setPassword(encoder.encode(customerDto.getPassword()));
        customerRepository.save(customer);
        return new Response("Успешно");

    }






}

