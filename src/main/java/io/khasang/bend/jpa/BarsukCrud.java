package io.khasang.bend.jpa;

import io.khasang.bend.entity.Barsuk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BarsukCrud extends JpaRepository<Barsuk, Long> {
    Barsuk findById(long id);
    List<Barsuk> findByName(String name);
}
