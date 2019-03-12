package io.khasang.bend;

import io.khasang.bend.entity.School;
import io.khasang.bend.entity.Trainer;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class TrainerControllerIntegrationTest {

    private static final String ROOT = "http://localhost:8080/trainer";
    private static final String ADD = "/add";
    private static final String GET_BY_ID = "/get";
    private static final String GET_ALL = "/all";

    @Test
    public void checkBarsukAdding() {
        Trainer trainer = createTrainer();
        RestTemplate restTemplate = new RestTemplate();
        //https://www.baeldung.com/rest-template
        //restTemplate.exchange - таким образом мы можем отправить rest POST
        ResponseEntity<Trainer> responseEntity = restTemplate.exchange(
                ROOT+GET_BY_ID+"/{id}",
                HttpMethod.GET,
                null,
                Trainer.class,
                trainer.getId()
        );
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Trainer recievedTrainer = responseEntity.getBody();
        Assert.assertNotNull(recievedTrainer);
    }

    private Trainer createTrainer() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Trainer trainer = prefillTrainer();
        HttpEntity<Trainer> entity = new HttpEntity<>(trainer, headers);
        RestTemplate template = new RestTemplate();
        //https://www.baeldung.com/rest-template
        //restTemplate.exchange - таким образом мы можем отправить rest POST
        Trainer createdTrainer = template.exchange(
                ROOT+ADD,
                HttpMethod.POST,
                entity,
                Trainer.class
        ).getBody();
        Assert.assertNotNull(createdTrainer);
        Assert.assertEquals("Ivan", createdTrainer.getName());
        return createdTrainer;
    }

    private Trainer prefillTrainer() {
        Trainer trainer = new Trainer();
        trainer.setName("Ivan");
        trainer.setDescription("good");
        trainer.setAvatarSrc("/gdg/dgfdgd.jpg");

        School school = new School();
        school.setName("schoolname");
        school.setDescription("schooldesc");

        School school2 = new School();
        school2.setName("schoolname2");
        school2.setDescription("schooldesc2");

        List<School> list = new ArrayList();
        list.add(school);
        list.add(school2);
        trainer.setSchoolList(list);
        return trainer;
    }
}