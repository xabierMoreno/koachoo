package com.app.koachoo.service;

import com.app.koachoo.client.GoalClient;
import com.app.koachoo.dto.Goal;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GoalsServiceImpl implements GoalsService {

    private GoalClient goalClient;

    public GoalsServiceImpl(final GoalClient goalClient){
        this.goalClient = goalClient;
    }

    @Override
    public List<Goal> getGoals() {
        return goalClient.getGoals();
    }
}
