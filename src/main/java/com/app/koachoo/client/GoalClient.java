package com.app.koachoo.client;

import com.app.koachoo.dto.Goal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "goals", url = "http://localhost:8081/")
public interface GoalClient {
    @GetMapping(value = "/goals")
    List<Goal> getGoals();
}