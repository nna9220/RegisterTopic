package hcmute.edu.vn.registertopic_be.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "lecturer")
@NoArgsConstructor
@AllArgsConstructor
public class Lecturer implements Serializable {

    @Id
    @Column(name = "lecturer_id", columnDefinition = "VARCHAR(255)")
    private String lecturerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturer_id", referencedColumnName = "person_id")
    private Person person;

    @Column(name="role")
    private Role role;

    @Column(name="major")
    private Major major;

    @OneToMany(mappedBy = "instructorId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Subject> listSubInstruct;

    @OneToMany(mappedBy = "thesisAdvisorId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Subject> listSubCounterArgument;

    @OneToMany(mappedBy = "instructorId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Task> tasks;
}
