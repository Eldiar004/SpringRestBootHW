package com.example.springrestboothw.entities;
import com.example.springrestboothw.entities.enums.StudyFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq",
            sequenceName = "student_seq",
            allocationSize = 1)
    @Column(length = 100000)
    private Long id;

    @Column(length = 100000)
    private String firstName;

    @Column(length = 100000)
    private String lastName;

    @Column(length = 100000)
    private String phoneNumber;

    @Column(length = 100000)
    private String email;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.REFRESH})
    private Group group;

    private StudyFormat studyFormat;

}