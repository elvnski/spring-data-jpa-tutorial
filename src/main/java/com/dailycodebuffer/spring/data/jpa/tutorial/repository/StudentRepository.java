package com.dailycodebuffer.spring.data.jpa.tutorial.repository;


import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentByFirstName(String firstName);

    List<Student> findStudentByFirstNameContaining(String firstName);

    List<Student> findStudentByLastNameNotNull();

    List<Student> findStudentByGuardian_Name(String guardianName);

    /* JPQL Queries are defined based on the classes you've created */
    @Query("Select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("Select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    /* Using native SQL queries */
    @Query(nativeQuery = true,
            value = "Select * from tbl_student s where s.email_address = ?1"
    )
    String getStudentFirstNameByEmailAddress_Native(String emailId);

    /* Using native SQL queries with NAMED PARAMETERS*/
    @Query(nativeQuery = true,
            value = "Select * from tbl_student s where s.email_address = :emailId"
    )
    String getStudentFirstNameByEmailAddress_NativeNamedParam(@Param("emailId") String emailId);


    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "Update tbl_student set first_name = ?1 where email_address = ?2"
    )
    int updateStudentNameByEmailId(String firstName, String emailId);

}
