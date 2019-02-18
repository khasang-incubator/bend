package io.khasang.bend.service.impl;

import io.khasang.bend.service.KnightService;
import org.springframework.stereotype.Service;

@Service
public class KnightServiceImpl implements KnightService {

    @Override
    public String getAchievement(String val) throws IllegalArgumentException {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (val.equalsIgnoreCase("dragon")) {
            System.err.println("I can't enslaved a dragon!");
            throw new IllegalArgumentException("I can't enslaved a dragon!");
        }
        return "I enslaved a " + val + "!";
    }
}
