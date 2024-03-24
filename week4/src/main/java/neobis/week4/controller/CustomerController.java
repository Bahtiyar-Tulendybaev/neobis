package neobis.week4.controller;

import neobis.week4.dto.CustomerDto;

import neobis.week4.entity.Customer;

import neobis.week4.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
        @Autowired
        CustomerService customerService;


        @GetMapping(value="/all")
        public List<Customer> getAllCustomer() {

            return customerService.getAllCustomer();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id){

            return customerService.findById(id);
        }


        @PostMapping("/add")
        public CustomerDto addCustomer(@RequestBody CustomerDto customer ) {
            customerService.AddNewCustomer(customer);
            return customer;

        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Customer> deleteProduct(@PathVariable ("id") Long id){

            return customerService.deleteById(id);

        }



    }



