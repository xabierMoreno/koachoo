package com.app.koachoo.service;

import com.app.koachoo.dto.Goal;
import com.app.koachoo.repository.GoalsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GoalsServiceImplTest {

    @Mock
    private GoalsRepository goalsRepository;

    @InjectMocks
    private GoalsServiceImpl goalsService;

    @Test
    public void goalsByUserTest() {

        Goal goal1 = Goal.builder().id(1).name("test").build();
        Goal goal2 =  Goal.builder().id(1).name("xabi").build();
        Goal goal3 = Goal.builder().id(1).name("test").build();

        List<Goal> goals = new ArrayList<>(Arrays.asList(goal1, goal2, goal3));
        when(goalsRepository.getGoalsByUser(any(String.class))).thenReturn(goals);
        List<Goal> goalList = goalsService.goalsByUser("test");
        assertEquals(2, goalList.size());

        goalList = goalsService.goalsByUser("xabi");
        assertEquals(1, goalList.size());
    }
}