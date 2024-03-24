package neobis.week4.service;


import lombok.AllArgsConstructor;
import neobis.week4.dto.CustomerDto;
import neobis.week4.dto.OrderDto;
import neobis.week4.entity.Customer;
import neobis.week4.entity.Order;
import neobis.week4.exception.ResourceNotFoundException;
import neobis.week4.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;

    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }

    public ResponseEntity<Order> findById(Long id) {

        Order order = orderRepository.findById(id)
         .orElseThrow(() -> new ResourceNotFoundException("Order was not found"));
        return ResponseEntity.ok(order);

    }

    public ResponseEntity<Order> deleteById(Long id) {
        Order order = orderRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Order was not found"));
        orderRepository.deleteById(id);
        return ResponseEntity.ok(order);
    }
    public void AddNewOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setQuantity(orderDto.getQuantity());
        order.setPrice(orderDto.getPrice());
        order.setDateAdd(orderDto.getDateAdd());
        order.setCustomer(orderDto.getCustomer());
        order.setProduct(orderDto.getProduct());
        orderRepository.save(order);
    }


}
