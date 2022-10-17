package com.dailycodebuffer.spring.data.jpa.tutorial.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
    @GeneratedValue(generator = "teacher_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;

//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
//    private List<Course> courses;


}
