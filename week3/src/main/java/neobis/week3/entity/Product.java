package neobis.week3.entity;



import lombok.*;

import javax.persistence.*;


@Data
@Entity
@Builder
@Table(name = "products")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 128)
    private String name;


    @Column(length = 128)
    private String image;



    @Column
    private String description;


    @Column
    private Integer price;



}
