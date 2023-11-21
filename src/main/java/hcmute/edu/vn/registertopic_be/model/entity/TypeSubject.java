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
@Table(name = "type_subject")
@NoArgsConstructor
@AllArgsConstructor
public class TypeSubject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="type_id")
    private int typeId;

    @Column(name="type_name")
    private String typeName;

    @OneToMany(mappedBy = "typeSubject", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Subject> subjectsList;

    @OneToMany(mappedBy = "typeSubjectId",orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    @Size(max = 2)
    private List<RegistrationPeriod> registrationPeriods;
}
