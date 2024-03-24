package neobis.week4.service;


import lombok.AllArgsConstructor;
import neobis.week4.dto.CustomerDto;
import neobis.week4.entity.Customer;
import neobis.week4.exception.ResourceNotFoundException;
import neobis.week4.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {

        return customerRepository.findAll();
    }

    public ResponseEntity<Customer> findById(Long id) {
          Customer customer = customerRepository.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("Customer was not found"));
        return ResponseEntity.ok(customer);
    }

    public ResponseEntity<Customer> deleteById(Long id) {
           Customer customer = customerRepository.findById(id)
           .orElseThrow(() -> new ResourceNotFoundException("Customer was not found"));
           customerRepository.deleteById(id);
           return ResponseEntity.ok(customer);
    }
    public void AddNewCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
       customer.setName(customerDto.getName());
       customer.setEmail(customerDto.getEmail());
       customer.setPassword(customerDto.getPassword());
        customerRepository.save(customer);
    }


}
