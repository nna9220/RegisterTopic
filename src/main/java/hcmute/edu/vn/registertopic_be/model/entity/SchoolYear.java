package hcmute.edu.vn.registertopic_be.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "school_year")
@NoArgsConstructor
@AllArgsConstructor
public class SchoolYear implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="year_id")
    private int yearId;

    @Column(name="year", length = 50)
    private String year;

    @OneToMany(mappedBy = "schoolYear", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Student> students = new ArrayList<>();
}
