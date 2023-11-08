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
@ToString
@Entity
@Table(name = "comment")
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_id")
    private int commentId;

    @ManyToOne
    @JoinColumn(name="task_id")
    private Task taskId;

    @ManyToOne
    @JoinColumn(name="poster")
    private Person poster;

    @Column(name="date_submit")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateSubmit;

    @Column(name="content")
    private String content;

    @OneToMany(mappedBy = "commentId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<File> files;

}
