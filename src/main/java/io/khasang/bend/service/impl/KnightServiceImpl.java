package io.khasang.bend.service.impl;

import io.khasang.bend.service.KnightService;
import org.springframework.stereotype.Service;

@Service
public class KnightServiceImpl implements KnightService {

    @Override
    public String getAchievement(String val) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (val.equalsIgnoreCase("dragon")) {
            throw new IllegalArgumentException("I can't slave a dragon!");
        }
        return "I am slave a " + val + "!";
    }

}
