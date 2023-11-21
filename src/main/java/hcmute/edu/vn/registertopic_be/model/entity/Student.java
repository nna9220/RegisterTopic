package hcmute.edu.vn.registertopic_be.model.entity;

import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "student_id", referencedColumnName = "person_id")
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    @Id
    @Column(name = "student_id", columnDefinition = "VARCHAR(255)")
    private String studentId;

/*    //Khóa ngoại tham chiếu đến person
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;*/

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

    @OneToMany(mappedBy = "assignTo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Task> tasks;
}
