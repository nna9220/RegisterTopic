package hcmute.edu.vn.registertopic_be.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
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

    @OneToMany(mappedBy = "subjectId",orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @Size(max = 2)
    private List<Student> students;

    @OneToMany(mappedBy = "subjectId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Task> tasks;

}
