package io.khasang.bend;

import io.khasang.bend.entity.Trainer;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class TrainerControllerIntegrationTest {

    private static final String ROOT = "http://localhost:8080/trainer";
    private static final String ADD = "/add";
    private static final String GET_BY_ID = "/get";
    private static final String GET_ALL = "/all";

    @Test
    public void checkBarsukAdding() {
        Trainer trainer = createTrainer();
    }

    private Trainer createTrainer() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Trainer trainer = prefillTrainer();
    }

    private Trainer prefillTrainer() {
    }
}
