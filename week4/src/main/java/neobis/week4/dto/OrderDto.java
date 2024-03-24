package neobis.week4.dto;


import lombok.Builder;
import lombok.Data;
import neobis.week4.entity.Customer;
import neobis.week4.entity.Product;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class OrderDto {

    private Long id;
    private Product product;
    private Customer customer;
    private Integer price;
    private Integer quantity;
    private Date dateAdd;


}
