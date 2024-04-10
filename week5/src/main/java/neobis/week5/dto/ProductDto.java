package neobis.week5.dto;
import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String image;
    private String description;
    private Integer price;


}
