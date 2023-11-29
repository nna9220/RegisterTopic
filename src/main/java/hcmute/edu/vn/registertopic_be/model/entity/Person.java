package hcmute.edu.vn.registertopic_be.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@ToString
@Entity
@Table(name = "person")
@AllArgsConstructor
public class Person implements OAuth2User, Serializable {
    @Id
    @Column(name = "person_id", columnDefinition = "VARCHAR(255)")
    private String personId;

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

    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "poster", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Comment> comments;

    public Person() {

    }


    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getName() {
        return null;
    }
}

