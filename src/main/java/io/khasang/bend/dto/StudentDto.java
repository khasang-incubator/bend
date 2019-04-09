package io.khasang.bend.dto;

import io.khasang.bend.entity.School;
import io.khasang.bend.entity.Student;
import io.khasang.bend.entity.User;
import io.khasang.bend.model.UserStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDto {
    private long id;
    private String experience;
    private String weight;
    private String height;
    private UserStatus status;
    private User user;
    private List<SchoolDto> schoolList = new ArrayList<>();

    public StudentDto getStudentDtoFromStudent(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setExperience(student.getExperience());
        studentDto.setHeight(student.getHeight());
        studentDto.setWeight(student.getWeight());
        studentDto.setStatus(student.getStatus());
        studentDto.setUser(student.getUser());

        List<SchoolDto> schoolDtos = new ArrayList<>();
        for (School school : student.getSchoolList()) {
            SchoolDto schoolDto = new SchoolDto();
            schoolDto.setId(school.getId());
            schoolDto.setName(school.getName());
            schoolDto.setDescription(school.getDescription());
            schoolDtos.add(schoolDto);
        }

        studentDto.setSchoolList(schoolDtos);
        return studentDto;
    }

    public List<StudentDto> getStudentDtoFromStudents(List<Student> students) {
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            studentDtos.add(getStudentDtoFromStudent(student));
        }
        return studentDtos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<SchoolDto> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<SchoolDto> schoolList) {
        this.schoolList = schoolList;
    }
}
