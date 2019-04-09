package io.khasang.bend.dto;

import io.khasang.bend.entity.Discipline;
import io.khasang.bend.entity.User;
import io.khasang.bend.model.Gender;
import io.khasang.bend.model.UserStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private String phoneNumber;
    private UserStatus userStatus;
    private Boolean isOnMap;
    private Boolean isHealthLimited;
    private String userDescription;
    private String interests;
    private List<DisciplineDto> disciplinesList = new ArrayList<>();

    public UserDto getUserDtoFromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastName());
        userDto.setAge(user.getAge());
        userDto.setGender(user.getGender());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setUserStatus(user.getUserStatus());
        userDto.setOnMap(user.getOnMap());
        userDto.setHealthLimited(user.getHealthLimited());
        userDto.setUserDescription(user.getUserDescription());
        userDto.setInterests(user.getInterests());

        List<DisciplineDto> tempDisciplineDto = new ArrayList<>();
        for (Discipline discipline : user.getDisciplinesList()) {
            DisciplineDto disciplineDto = new DisciplineDto();
            disciplineDto.setName(discipline.getName());
            disciplineDto.setId(discipline.getId());
            tempDisciplineDto.add(disciplineDto);
        }
        userDto.setDisciplinesList(tempDisciplineDto);
        return userDto;
    }

    public List<UserDto> getUserDtoListFromUser(List<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            userDtoList.add(getUserDtoFromUser(user));
        }
        return userDtoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public Boolean getOnMap() {
        return isOnMap;
    }

    public void setOnMap(Boolean onMap) {
        isOnMap = onMap;
    }

    public Boolean getHealthLimited() {
        return isHealthLimited;
    }

    public void setHealthLimited(Boolean healthLimited) {
        isHealthLimited = healthLimited;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public List<DisciplineDto> getDisciplinesList() {
        return disciplinesList;
    }

    public void setDisciplinesList(List<DisciplineDto> disciplinesList) {
        this.disciplinesList = disciplinesList;
    }
}
