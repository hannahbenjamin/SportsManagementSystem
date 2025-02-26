package com.example.cms.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "students")
public class Student extends Person {

    // one-to-many relationship between student and course mark. Each student can have multiple marks
    @OneToMany(mappedBy = "student")
    @Nullable
    private List<CourseMark> marks  = new ArrayList<>();
    // what this does is that it creates an arraylist with marks to be added to the marks table

    // Lab 5: extend student entity to include field that indicates department each
    // student is associated with (which can be empty) and define many-to-one relation
    // to the department entity (each dep can have many students but student only has one dep)
    @ManyToOne  // multiple courses can have the same classroom
    @Nullable
    @JoinColumn(name = "departmentCode")
    private Department department;
}
