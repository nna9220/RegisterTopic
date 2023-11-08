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
@Table(name = "lecturer")
@NoArgsConstructor
@AllArgsConstructor
public class Lecturer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecturer_id")
    private int lecturerId;

    //Khóa ngoại tham chiếu đến person
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name="role")
    private Role role;

    @Column(name="major")
    private Major major;

    @OneToMany(mappedBy = "instructorId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Subject> listSubInstruct;

    @OneToMany(mappedBy = "thesisAdvisorId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Subject> listSubCounterArgument;

    @OneToMany(mappedBy = "instructorId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Task> tasks;
}
