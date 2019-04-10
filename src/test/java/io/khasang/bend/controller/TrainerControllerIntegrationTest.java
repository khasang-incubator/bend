package io.khasang.bend.controller;

import io.khasang.bend.entity.Trainer;
import io.khasang.bend.entity.User;
import io.khasang.bend.model.Gender;
import io.khasang.bend.model.UserStatus;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TrainerControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/trainers";
    private static final String ADD = "/add";
    private static final String GET_BY_ID = "/get/{id}";
    private static final String GET_ALL = "/all";

    @Test
    public void checkAddTrainer() {
        Trainer trainer = createTrainer();
        RestTemplate template = new RestTemplate();
        ResponseEntity<Trainer> responseEntity = template.exchange(
                ROOT + GET_BY_ID,
                HttpMethod.GET,
                null,
                Trainer.class,
                trainer.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Trainer receivedTrainer = responseEntity.getBody();
        assertNotNull(receivedTrainer);
    }

    @Test
    public void checkGetAll() {
        createTrainer();
        checkAddTrainer();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Trainer>> responseEntity = restTemplate.exchange(
                ROOT + GET_ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Trainer>>() {
                }
        );

        List<Trainer> trainers = responseEntity.getBody();
        assertNotNull(trainers);
    }

    private Trainer createTrainer() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Trainer trainer = prefillTrainer();

        HttpEntity<Trainer> entity = new HttpEntity<>(trainer, headers);
        RestTemplate template = new RestTemplate();
        Trainer createdTrainer = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Trainer.class
        ).getBody();
        assertNotNull(createdTrainer);
        return createdTrainer;
    }

    private Trainer prefillTrainer() {
        Trainer trainer = new Trainer();
        trainer.setAchievements("Too old for this shit");
        trainer.setExperience("Wakeboarding");
        trainer.setExperienceAsTrainer(10);
        User user = new User();
        user.setName("Ivan");
        user.setLastName("Ivanov");
        user.setAge(30);
        user.setGender(Gender.MALE);
        user.setDateOfBirth(LocalDate.of(1989, 10, 10));
        user.setEmail("ivan.ivanov@gmail.com");
        user.setPassword("1234566");
        user.setPhoneNumber("800-900-1111");
        user.setUserStatus(UserStatus.EMPTY_STATUS);
        user.setOnMap(true);
        user.setHealthLimited(false);
        user.setUserDescription("Wakebord for life");
        user.setInterests("Wakeboarding");
        trainer.setUser(user);
        return trainer;
    }
}
