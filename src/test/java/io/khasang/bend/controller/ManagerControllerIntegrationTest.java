package io.khasang.bend.controller;

import io.khasang.bend.dto.UserDto;
import io.khasang.bend.entity.Manager;
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

public class ManagerControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/managers";
    private static final String ADD = "/add";
    private static final String GET_BY_ID = "/get/{id}";
    private static final String GET_ALL = "/all";

    @Test
    public void checkAddManager() {
        Manager manager = createManager();
        RestTemplate template = new RestTemplate();
        ResponseEntity<Manager> responseEntity = template.exchange(
                ROOT + GET_BY_ID,
                HttpMethod.GET,
                null,
                Manager.class,
                manager.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Manager receivedManager = responseEntity.getBody();
        assertNotNull(receivedManager);
    }

    @Test
    public void checkGetAll() {
        RestTemplate template = new RestTemplate();
        createManager();
        checkAddManager();

        ResponseEntity<List<Manager>> result = template.exchange(
                ROOT + GET_ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Manager>>() {
                }
        );

        List<Manager> managers = result.getBody();
        assertNotNull(managers);
    }

    private Manager prefillManager() {
        Manager manager = new Manager();
        manager.setContactTime("23:30");
        manager.setPublicContacts("contacts");
        User user = new User();
        user.setName("Ivan");
        user.setLastName("Dulin");
        user.setAge(40);
        user.setGender(Gender.NO_DATA);
        user.setDateOfBirth(LocalDate.of(1979, 10, 10));
        user.setEmail("ivan.dulin@gmail.com");
        user.setPassword("12345");
        user.setPhoneNumber("800-900-1010");
        user.setUserStatus(UserStatus.EMPTY_STATUS);
        user.setOnMap(true);
        user.setHealthLimited(false);
        user.setUserDescription("NERD");
        user.setInterests("Wakeboarding");
        manager.setUser(user);
        return manager;
    }

    private Manager createManager() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Manager manager = prefillManager();
        HttpEntity<Manager> entity = new HttpEntity<>(manager, headers);
        RestTemplate template = new RestTemplate();
        Manager createdManager = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Manager.class
        ).getBody();

        assertNotNull(createdManager);
        return createdManager;
    }

}
