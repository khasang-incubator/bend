package io.khasang.bend.controller;

import io.khasang.bend.entity.Student;
import io.khasang.bend.entity.User;
import io.khasang.bend.model.Gender;
import io.khasang.bend.model.StudentStatus;
import io.khasang.bend.model.UserStatus;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StudentControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/students";
    private static final String ADD = "/add";
    private static final String GET_BY_ID = "/get/{id}";
    private static final String GET_ALL = "/all";

    @Test
    public void checkAddStudent() {
        Student student = createStudent();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Student> entity = template.exchange(
                ROOT + GET_BY_ID,
                HttpMethod.GET,
                null,
                Student.class,
                student.getId()
        );
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        Student createdStudent = entity.getBody();
        assertNotNull(createdStudent);
    }

    @Test
    public void checkGetAllStudents() {
        createStudent();
        checkAddStudent();

        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Student>> entity = template.exchange(
                ROOT + GET_ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Student>>() {
                }
        );

        List<Student> students = entity.getBody();
        assertNotNull(students);
    }

    private Student createStudent() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Student student = prefillStudent();

        HttpEntity<Student> entity = new HttpEntity<>(student, headers);
        RestTemplate template = new RestTemplate();

        Student createdStudent = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Student.class
        ).getBody();
        assertNotNull(createdStudent);
        return createdStudent;
    }

    private Student prefillStudent() {
        Student student = new Student();
        student.setExperience("NOOB");
        student.setHeight("1.80");
        student.setStudentStatus(StudentStatus.VACANT);
        student.setWeight("70");
        User user = new User();
        user.setName("Kate");
        user.setLastName("Nobin");
        user.setAge(25);
        user.setGender(Gender.FEMALE);
        user.setDateOfBirth(LocalDate.of(1993, 10, 10));
        user.setEmail("kate.nobin@gmail.com");
        user.setPassword("pinkypink");
        user.setPhoneNumber("800-800-1000");
        user.setUserStatus(UserStatus.EMPTY_STATUS);
        user.setOnMap(true);
        user.setHealthLimited(false);
        user.setUserDescription("Kitty");
        user.setInterests("Cats");
        student.setUser(user);
        return student;
    }
}
