package hcmute.edu.vn.registertopic_be.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "subject")
@NoArgsConstructor
@AllArgsConstructor
public class Subject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subject_id")
    private int subjectId;

    @Column(name="subject_name")
    private String subjectName;

    @Column(name = "major", length = 50)
    @Enumerated(EnumType.STRING)
    private Major major;

    @ManyToOne
    @JoinColumn(name="instructor_id")
    private Lecturer instructorId;

    @ManyToOne
    @JoinColumn(name="thesisAdvisor_id")
    private Lecturer thesisAdvisorId;

    @Column(name="score")
    private Double score;

    @Column(name="review")
    private String review;

    @Column(name="requirement")
    private String requirement;

    @Column(name="expected")
    private String expected;

    @ManyToOne
    @JoinColumn(name="type_id_subject")
    private TypeSubject typeSubject;

    @Column(name="status")
    private byte status = 0;

    @Column(name = "student_1")
    private String student1;

    @OneToOne
    @JoinColumn(name="student_1", referencedColumnName = "student_id", insertable = false, updatable = false)
    private Student studentId1;

    @Column(name = "student_2")
    private String student2;

    @OneToOne
    @JoinColumn(name="student_2", referencedColumnName = "student_id", insertable = false, updatable = false)
    private Student studentId2;

    @OneToMany(mappedBy = "subjectId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Task> tasks;

    @Column(name="ÿear")
    private String year;
}
