package com.dailycodebuffer.spring.data.jpa.tutorial.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
    @GeneratedValue(generator = "course_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private Integer credit;

    @OneToOne(mappedBy = "course") /* Here we give the Course class object used to define the relationship in the CourseMaterial class */
    private CourseMaterial courseMaterial;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course_map",
    joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"))
    private List<Student> studentsList;


    public void addStudents(Student student){
        if(studentsList == null) studentsList = new ArrayList<>();
        studentsList.add(student);
    }

}
