package com.app.koachoo.service;


import com.app.koachoo.dto.Goal;
import com.app.koachoo.repository.GoalsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalsServiceImpl implements GoalsService {

    private GoalsRepository goalsRepository;

    public GoalsServiceImpl(final GoalsRepository goalsRepository){
        this.goalsRepository = goalsRepository;
    }

    @Override
    public List<Goal> getGoals() {
        return goalsRepository.getGoals();
    }

    @Override
    public List<Goal> goalsByUser(String userId) {
        List<Goal> goalByUser = goalsRepository.getGoalsByUser(userId).stream().filter(goal -> { return goal.getName().equals(userId);}).collect(Collectors.toList());
        return goalByUser;
    }
}
