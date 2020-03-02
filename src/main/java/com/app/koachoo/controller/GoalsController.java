package com.app.koachoo.controller;

import com.app.koachoo.dto.Goal;
import com.app.koachoo.service.GoalsService;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RestController
public class GoalsController {

    private GoalsService goalsService;

    public GoalsController(final GoalsService goalsService){
        this.goalsService = goalsService;
    }

    @RequestMapping("/goals")
    public List<Goal> goals() {
        return goalsService.getGoals();
    }
}
