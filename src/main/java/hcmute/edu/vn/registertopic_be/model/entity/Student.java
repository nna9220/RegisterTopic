package hcmute.edu.vn.registertopic_be.model.entity;

import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    //Khóa ngoại tham chiếu đến person
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "major", length = 50)
    @Enumerated(EnumType.STRING)
    private Major major;

    @ManyToOne
    @JoinColumn(name="class_id")
    private StudentClass studentClass;

    @ManyToOne
    @JoinColumn(name="year_id")
    private SchoolYear schoolYear;

    @ManyToOne
    @JoinColumn(name="subject_id")
    private Subject subjectId;

    @OneToMany(mappedBy = "assignTo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Task> tasks;
}
