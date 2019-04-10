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
    private List<User> userList = new ArrayList<>();
    private List<SchoolDto> schoolList = new ArrayList<>();

    public DisciplineDto getDisciplineDtoFromDiscipline(Discipline discipline){
        DisciplineDto disciplineDto = new DisciplineDto();
        disciplineDto.setId(discipline.getId());
        disciplineDto.setName(discipline.getName());

        List<SchoolDto> schoolDtos = new ArrayList<>();
        for (School school : discipline.getSchoolList()) {
            SchoolDto schoolDto = new SchoolDto();
            schoolDto.setId(school.getId());
            schoolDto.setName(school.getName());
            schoolDto.setDescription(school.getDescription());
            schoolDtos.add(schoolDto);
        }

        disciplineDto.setSchoolList(schoolDtos);
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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<SchoolDto> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<SchoolDto> schoolList) {
        this.schoolList = schoolList;
    }
}
