package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        List<Course> courseList = new LinkedList<>();

        Course course1 = Course.builder()
                .title("DSA")
                .credit(6)
                .build();
        Course course2 = Course.builder()
                .title("CICD")
                .credit(7)
                .build();
        courseList.add(course1);
        courseList.add(course2);


        Teacher teacher = Teacher.builder()
                .firstName("Konig")
                .lastName("Wolke")
//                .courses(courseList)
                .build();

        teacherRepository.save(teacher);

    }
}