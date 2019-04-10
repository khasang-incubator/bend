package io.khasang.bend.dto;

import io.khasang.bend.entity.School;
import io.khasang.bend.entity.Trainer;
import io.khasang.bend.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TrainerDto {
    private long id;
    private int experienceAsTrainer;
    private String experience;
    private String achievements;
    private User user;
    private List<SchoolDto> schoolList = new ArrayList<>();

    public TrainerDto getTrainerDtoFromTrainer(Trainer trainer) {
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setId(trainer.getId());
        trainerDto.setExperienceAsTrainer(trainer.getExperienceAsTrainer());
        trainerDto.setExperience(trainer.getExperience());
        trainerDto.setAchievements(trainer.getAchievements());
        trainerDto.setUser(trainer.getUser());

        return trainerDto;
    }

    public List<TrainerDto> getTrainerDtoFromTrainers(List<Trainer> trainers) {
        List<TrainerDto> trainerDtos = new ArrayList<>();
        for (Trainer trainer : trainers) {
            trainerDtos.add(getTrainerDtoFromTrainer(trainer));
        }
        return trainerDtos;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
