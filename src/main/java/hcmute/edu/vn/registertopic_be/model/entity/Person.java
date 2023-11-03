package hcmute.edu.vn.registertopic_be.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "fistname")
    private String firstname;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "sex")
    private int sex;
    @Column(name = "roleid")
    private int roleid;
    @Column(name = "birthday")
    private String birthday;


}
