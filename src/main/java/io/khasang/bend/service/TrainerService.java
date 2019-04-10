package io.khasang.bend.service;

import io.khasang.bend.entity.Trainer;

import java.util.List;

public interface TrainerService {
    Trainer add(Trainer trainer);

    Trainer update(Trainer trainer);

    Trainer delete(long id);

    Trainer getById(long id);

    List<Trainer> getAllTrainers();
}
