package io.khasang.bend.service;

import io.khasang.bend.dto.TrainerDto;
import io.khasang.bend.entity.Trainer;

import java.util.List;

public interface TrainerDtoService {
    Trainer add(Trainer student);

    Trainer update(Trainer student);

    Trainer delete(long id);

    TrainerDto getById(long id);

    List<TrainerDto> getAll();
}
