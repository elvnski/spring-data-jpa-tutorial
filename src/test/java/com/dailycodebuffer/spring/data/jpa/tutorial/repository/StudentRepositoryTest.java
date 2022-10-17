package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;



/* Used when we don't want to keep test results in our db */
//@DataJpaTest

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){

        Student student = Student.builder()
                .firstName("Shabbir")
                .lastName("Dawoodi")
                .emailId("shabbir@dcb.com")
                //.guardianName("Nikhil")
                //.guardianMobile("9999999999")
                //.guardianEmail("nikhil@dcb.com")
                .build();
        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("Nikhil")
                .mobile("9484829472")
                .email("nikhil@dcb.com")
                .build();

        Student student = Student.builder()
                .firstName("Shivam")
                .lastName("Kumar")
                .emailId("shivam@dcb.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    public void printAllStudents(){

        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student List = " + studentList);

    }

    @Test
    public void printStudentByFirstName(){

        List<Student> students = studentRepository.findStudentByFirstName("Shivam");
        System.out.println("Students found: " + students);

    }

    @Test
    public void printStudentByFirstNameContaining(){

        List<Student> students = studentRepository.findStudentByFirstNameContaining("va");
        System.out.println("Students found: " + students);

    }

    @Test
    public void printStudentByGuardianName(){

        List<Student> students = studentRepository.findStudentByGuardian_Name("Nikhil");
        System.out.println("Students found: " + students);

    }

    @Test
    public void printStudentByEmailAddress(){

        Student students = studentRepository.getStudentByEmailAddress("shabbir@dcb.com");
        System.out.println("Students found: " + students);

    }

    @Test
    public void printStudentFirstNameByEmailAddress(){

        String students = studentRepository.getStudentFirstNameByEmailAddress("shabbir@dcb.com");
        System.out.println("Students first name found: " + students);

    }

    @Test
    public void printStudentFirstNameByEmailAddress_Native(){

        String students = studentRepository.getStudentFirstNameByEmailAddress_Native("shabbir@dcb.com");
        System.out.println("Students found: " + students);

    }

    @Test
    public void printStudentFirstNameByEmailAddress_NativeNamedParam(){

        String students = studentRepository.getStudentFirstNameByEmailAddress_NativeNamedParam("shabbir@dcb.com");
        System.out.println("Students  found: " + students);

    }

    @Test
    public void updateStudentNameByEmailId(){

        studentRepository.updateStudentNameByEmailId("Amadeus Wolfgang", "shabbir@dcb.com");

    }






}