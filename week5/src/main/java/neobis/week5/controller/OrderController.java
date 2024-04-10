package neobis.week5.controller;

import neobis.week5.dto.OrderDto;
import neobis.week5.entity.Order;
import neobis.week5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;


    @GetMapping(value="/all")
    public ResponseEntity<?> getAllOrders() {

        return ResponseEntity.ok().body( orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable("id") Long id){

        return ResponseEntity.ok().body(orderService.findById(id)) ;
    }


    @PostMapping("/add")
    public ResponseEntity<?> addOrder(@RequestBody OrderDto order) {
        orderService.AddNewOrder(order);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable ("id") Long id){
       return orderService.deleteById(id);

    }
}
