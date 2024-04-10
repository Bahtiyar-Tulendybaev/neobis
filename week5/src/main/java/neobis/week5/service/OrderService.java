package neobis.week5.service;


import lombok.AllArgsConstructor;
import neobis.week5.dto.OrderDto;
import neobis.week5.entity.Order;
import neobis.week5.exception.ResourceNotFoundException;
import neobis.week5.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


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
        order.setCustomer(orderDto.getCustomer());
        order.setProduct(orderDto.getProduct());
        orderRepository.save(order);
    }


}
