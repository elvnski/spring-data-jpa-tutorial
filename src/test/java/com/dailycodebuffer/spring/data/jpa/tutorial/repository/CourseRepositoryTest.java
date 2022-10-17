package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses Available: " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Kody")
                .lastName("Simpson")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(8)
                .teacher(teacher)
                .build();

        courseRepository.save(course);

    }

    /* How to use pagination */
    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();

        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();


        System.out.println("Courses found: " + courses + "\nTotal Pages: " + totalPages + "\nTotal Elements: " + totalElements);

    }

    @Test
    public void findAllSorting(){

        Pageable sortByTitle = PageRequest.of(0, 3, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0,3, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,3, Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();

        System.out.println("Courses found: " + courses);

    }

    @Test
    public void printFindByTitleContaining(){

        Pageable firstPageTenRecords = PageRequest.of(0, 10);

        List<Course> courses = courseRepository.findByTitleContaining("P", firstPageTenRecords).getContent();

        System.out.println("Courses found: " + courses);

    }

}