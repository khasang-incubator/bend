package io.khasang.bend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trainers")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trainer_id")
    private long id;
    @Column(name = "experience_as_trainer")
    private int experienceAsTrainer;
    @Column(name = "experience_description")
    private String experience;
    private String achievements;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private User user;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "trainersList")
    private List<School> schoolList = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getExperienceAsTrainer() {
        return experienceAsTrainer;
    }

    public void setExperienceAsTrainer(int experienceAsTrainer) {
        this.experienceAsTrainer = experienceAsTrainer;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public List<School> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
    }
}