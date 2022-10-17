package com.dailycodebuffer.spring.data.jpa.tutorial.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(exclude = "course")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseMaterial {

    @Id
    @SequenceGenerator(name = "courseMaterial_sequence", sequenceName = "courseMaterial_sequence", allocationSize = 1)
    @GeneratedValue(generator = "courseMaterial_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String url;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)/* false optional demands that a course material should be created along with a course */
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

}
