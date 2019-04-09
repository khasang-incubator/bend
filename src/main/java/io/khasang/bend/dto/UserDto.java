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
    private long id;
    private String name;
    private String lastName;
    private int age;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private String phoneNumber;
    private UserStatus userStatus;
    private boolean isOnMap;
    private boolean isHealthLimited;
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
        userDto.setOnMap(user.isOnMap());
        userDto.setHealthLimited(user.isHealthLimited());
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public boolean isOnMap() {
        return isOnMap;
    }

    public void setOnMap(boolean onMap) {
        isOnMap = onMap;
    }

    public boolean isHealthLimited() {
        return isHealthLimited;
    }

    public void setHealthLimited(boolean healthLimited) {
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
