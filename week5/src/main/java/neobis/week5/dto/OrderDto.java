package neobis.week5.dto;


import lombok.Builder;
import lombok.Data;
import neobis.week5.entity.User;
import neobis.week5.entity.Product;

@Data
@Builder
public class OrderDto {

    private Long id;
    private Product product;
    private User customer;
    private Integer price;
    private Integer quantity;



}
