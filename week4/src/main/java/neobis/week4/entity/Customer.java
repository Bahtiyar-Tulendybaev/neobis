package neobis.week4.entity;



import lombok.*;

import javax.persistence.*;



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


    @Column(length = 128)
    @Builder.Default
    private String role = "USER";

}
