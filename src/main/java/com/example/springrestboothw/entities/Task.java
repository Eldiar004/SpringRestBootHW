package com.example.springrestboothw.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    @SequenceGenerator(name = "task_seq",
            sequenceName = "task_seq",
            allocationSize = 1)
    @Column(length = 100000)
    private Long id;

    @Column(length = 100000)
    private String taskName;

    @Column(length = 100000)
    private String taskTest;

    @Column(length = 100000)
    private String deadline;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.REFRESH})
    private Lesson lesson;

}
