package io.khasang.bend.service;

import io.khasang.bend.entity.Admin;
import io.khasang.bend.entity.Barsuk;
import io.khasang.bend.entity.School;

import java.util.List;

public interface AdminService {
    List<School> getAllSchools();
}