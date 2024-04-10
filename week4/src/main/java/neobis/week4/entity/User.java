package neobis.week5.entity;



import jakarta.persistence.*;
import lombok.*;





@Data
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    private String name;
    private String password;
    private String role;

}
