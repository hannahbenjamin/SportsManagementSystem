package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "courses")
public class Course {

    @Id
    @NotEmpty
    private String code;

    @NotEmpty
    private String name;

    // multiple courses can be taught by one professor
    @ManyToOne
    @JoinColumn(name="professorId")
    private Professor professor;

    // each course can have multiple course marks
    @OneToMany(mappedBy = "course")
    @Nullable
    private List<CourseMark> marks = new ArrayList<>();

    // LAB 4
    // Want to extend the Course entity to include a field for classroom
    // adding Classroom as a class attribute in order to connect each course to a classroom
    @ManyToOne  // multiple courses can have the same classroom
    @JoinColumn(name = "classroomCode")
    private Classroom classroom;

    // LAB 4: added Classroom classroom to the Course constructor
    public Course(String code, String name, Professor professor, Classroom classroom){
        this.code = code;
        this.name = name;
        this.professor = professor;
        this.classroom = classroom;
    }
}
