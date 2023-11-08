package hcmute.edu.vn.registertopic_be.model.entity;

import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table(name = "student_class")
@NoArgsConstructor
@AllArgsConstructor
public class StudentClass implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="classname", length = 50)
    private String classname;

    @OneToMany(mappedBy = "studentClass", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Student> students;
}
