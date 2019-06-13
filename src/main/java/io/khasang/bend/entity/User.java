package io.khasang.bend.entity;

import io.khasang.bend.model.Gender;
import io.khasang.bend.model.UserStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private Integer age;
    @Enumerated
    private Gender gender;
    @Column(name = "birth_date", columnDefinition = "DATE")
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Enumerated
    @Column(name = "user_status")
    private UserStatus userStatus;
    private Boolean isOnMap;
    private Boolean isHealthLimited;
    @Column(name = "user_description")
    private String userDescription;
    private String interests;
    @Column(name = "role_id")
    private Integer role;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private HomePagesUrl url;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Discipline> disciplinesSet = new HashSet<>();

    public Set<Discipline> getDisciplinesSet() {
        return disciplinesSet;
    }

    public void setDisciplinesSet(Set<Discipline> disciplinesList) {
        this.disciplinesSet = disciplinesSet;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
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
        this.password = new BCryptPasswordEncoder().encode(password);
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

    public HomePagesUrl getUrl() {
        return url;
    }

    public void setUrl(HomePagesUrl url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (!name.equals(user.name)) return false;
        if (!lastName.equals(user.lastName)) return false;
        if (!age.equals(user.age)) return false;
        return gender == user.gender;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + name.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }
}
