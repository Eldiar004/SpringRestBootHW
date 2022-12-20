package com.example.springrestboothw.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    @SequenceGenerator(name = "course_seq",
            sequenceName = "course_seq",
            allocationSize = 1)
    @Column(length = 100000)
    private Long id;

    @Column(length = 100000)
    private String courseName;

    @Column(length = 100000)
    private String duration;

    @Column(length = 100000)
    private String description;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private Company company;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.REMOVE},mappedBy = "courses",
            fetch = FetchType.EAGER)
    private List<Group> groups;
    public void addGroup(Group group){
        if (groups==null) {
            groups = new ArrayList<>();
        }
        groups.add(group);
    }
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "course")
    private List<Instructor> instructors;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "course")
    private List<Lesson>lessons;
}
