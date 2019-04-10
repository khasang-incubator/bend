package io.khasang.bend.dto;

import io.khasang.bend.entity.Discipline;
import io.khasang.bend.entity.School;
import io.khasang.bend.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DisciplineDto {
    private Long id;
    private String name;
    private Set<User> userSet = new HashSet<>();
    private Set<SchoolDto> schoolSet = new HashSet<>();

    public DisciplineDto getDisciplineDtoFromDiscipline(Discipline discipline){
        DisciplineDto disciplineDto = new DisciplineDto();
        disciplineDto.setId(discipline.getId());
        disciplineDto.setName(discipline.getName());

        Set<SchoolDto> schoolDtos = new HashSet<>();
        for (School school : discipline.getSchoolSet()) {
            SchoolDto schoolDto = new SchoolDto();
            schoolDto.setId(school.getId());
            schoolDto.setName(school.getName());
            schoolDto.setDescription(school.getDescription());
            schoolDtos.add(schoolDto);
        }

        disciplineDto.setSchoolSet(schoolDtos);
        return disciplineDto;
    }

    public Set<DisciplineDto> getDisciplineDtoSetFromDisciplines(Set<Discipline> disciplines) {
        Set<DisciplineDto> disciplineDtos = new HashSet<>();
        for (Discipline discipline : disciplines) {
            disciplineDtos.add(getDisciplineDtoFromDiscipline(discipline));
        }
        return disciplineDtos;
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

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public Set<SchoolDto> getSchoolSet() {
        return schoolSet;
    }

    public void setSchoolSet(Set<SchoolDto> schoolList) {
        this.schoolSet = schoolSet;
    }
}
