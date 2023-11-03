package hcmute.edu.vn.registertopic_be.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "file")
@NoArgsConstructor
@AllArgsConstructor
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="file_id")
    private int fileId;

    @ManyToOne
    @JoinColumn(name="task_id")
    private Task taskId;

    @ManyToOne
    @JoinColumn(name="comment_id")
    private Comment commentId;
}
