package com.app.koachoo.repository;

import com.app.koachoo.dto.Goal;

import java.util.List;

public interface GoalsRepository {

    List<Goal> getGoals();
    List<Goal> getGoalsByUser(String id);
}
