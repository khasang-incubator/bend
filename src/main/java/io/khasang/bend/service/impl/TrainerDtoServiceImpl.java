package io.khasang.bend.service.impl;

import io.khasang.bend.dao.TrainerDao;
import io.khasang.bend.dto.TrainerDto;
import io.khasang.bend.entity.Trainer;
import io.khasang.bend.service.TrainerDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("trainerDtoService")
public class TrainerDtoServiceImpl implements TrainerDtoService {
    private TrainerDao trainerDao;
    private TrainerDto trainerDto;

    @Override
    public Trainer add(Trainer trainer) {
        return trainerDao.add(trainer);
    }

    @Override
    public Trainer update(Trainer trainer) {
        return trainerDao.update(trainer);
    }

    @Override
    public Trainer delete(long id) {
        return trainerDao.delete(trainerDao.getById(id));
    }

    @Override
    public TrainerDto getById(long id) {
        return trainerDto.getTrainerDtoFromTrainer(trainerDao.getById(id));
    }

    @Override
    public List<TrainerDto> getAll() {
        return trainerDto.getTrainerDtoFromTrainers(trainerDao.getAll());
    }

    @Autowired
    public void setTrainerDao(TrainerDao trainerDao) {
        this.trainerDao = trainerDao;
    }

    @Autowired
    public void setTrainerDto(TrainerDto trainerDto) {
        this.trainerDto = trainerDto;
    }
}
