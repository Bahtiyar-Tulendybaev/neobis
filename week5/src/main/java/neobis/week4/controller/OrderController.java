package neobis.week4.controller;

import neobis.week4.dto.OrderDto;
import neobis.week4.entity.Order;
import neobis.week4.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;


    @GetMapping(value="/all")
    public List<Order> getAllOrders() {

        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") Long id){

        return orderService.findById(id);
    }


    @PostMapping("/add")
    public OrderDto addOrder(@RequestBody OrderDto order) {
        orderService.AddNewOrder(order);
        return order;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable ("id") Long id){
       return orderService.deleteById(id);

    }
}
