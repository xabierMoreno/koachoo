package com.app.koachoo.controller;

import com.app.koachoo.dto.Goal;
import com.app.koachoo.exceptions.GoalsNotFoundException;
import com.app.koachoo.service.GoalsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/goals/by-user/")
    public List<Goal> goalsById(){
        return  goalsService.goalsByUser("test");
    }

    @GetMapping("/goals/{id}")
    Goal findGoal(@PathVariable Long id) throws GoalsNotFoundException {
       throw new GoalsNotFoundException(id);
    }
}
