package hcmute.edu.vn.registertopic_be.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int personId;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "fistname")
    private String firstName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private byte gender;

    @Column(name = "role", length = 50)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "birth_Day")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String birthDay;

    @Column(name = "password")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "Mật khẩu không đáp ứng yêu cầu bảo mật")
    private String password;

    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "poster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Comment> comments;

}
