package com.app.koachoo.repository;

import com.app.koachoo.client.GoalClient;
import com.app.koachoo.dto.Goal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class GoalsRepositoryImpl implements GoalsRepository {

    private final  GoalClient goalClient;

    public GoalsRepositoryImpl(final GoalClient goalClient){
        this.goalClient = goalClient;
    }

    @Override
    public List<Goal> getGoals() {
        return goalClient.getGoals();
    }

    @Override
    public List<Goal> getGoalsByUser(String id) {
        Goal goal1 = Goal.builder().id(1).name("test").build();
        Goal goal2 =  Goal.builder().id(1).name("xabi").build();
        Goal goal3 = Goal.builder().id(1).name("test").build();

        return new ArrayList<>(Arrays.asList(goal1,goal2, goal3));
    }
}
