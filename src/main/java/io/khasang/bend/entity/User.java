package io.khasang.bend.entity;

import io.khasang.bend.model.ActivityType;
import io.khasang.bend.model.Sex;
import io.khasang.bend.model.UserStatus;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private int age;
    @Enumerated
    private Sex sex;
    @Column(name = "birth_date", columnDefinition = "DATE")
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Enumerated
    @Column(name = "activity_type")
    private ActivityType activityType;
    @Enumerated
    @Column(name = "user_status")
    private UserStatus userStatus;
    private boolean isOnMap;
    private boolean isHealthLimited;
    @Column(name = "user_description")
    private String userDescription;
    private String interests;
    @Enumerated
    @Column(name = "activity_interests")
    private ActivityType activityInterests;

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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
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

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
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

    public ActivityType getActivityInterests() {
        return activityInterests;
    }

    public void setActivityInterests(ActivityType activityInterests) {
        this.activityInterests = activityInterests;
    }
}
