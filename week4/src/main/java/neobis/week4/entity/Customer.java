package neobis.week4.entity;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;




@Data
@Table(name = "customers")
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 128)
    private String name;

    @Column(length = 128)
    private String email;

    @Column(length = 128)
    private String password;

}
