package hcmute.edu.vn.registertopic_be.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="task_id")
    private int taskId;

    @Column(name="requirement")
    private String requirement;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="time_start")
    private Date timeStart;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="time_end")
    private Date timeEnd;

    @ManyToOne
    @JoinColumn(name="subject_id")
    private Subject subjectId;

    @ManyToOne
    @JoinColumn(name="instructor_id", columnDefinition = "VARCHAR(255)")
    private Lecturer instructorId;

    @ManyToOne
    @JoinColumn(name="assign_to", columnDefinition = "VARCHAR(255)")
    private Student assignTo;

    @OneToMany(mappedBy = "taskId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Comment> comments;

    @OneToMany(mappedBy = "taskId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<File> files;
}
