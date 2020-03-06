package com.app.koachoo.service;

import com.app.koachoo.dto.Goal;
import com.app.koachoo.dto.UserDto;
import com.app.koachoo.request.JwtRequest;
import com.app.koachoo.request.JwtResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GoalsControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {

        String url = "http://localhost:" + port;
        String USERNAME = "test";
        String PASSWORD = "password";

        UserDto userDto = UserDto.builder().username(USERNAME).password(PASSWORD).build();
        HttpEntity<UserDto> entity = new HttpEntity<>(userDto, null);

        HttpEntity<String> exchange1 = restTemplate.exchange(url + "/register", HttpMethod.POST, entity, String.class);
        assertNotNull(exchange1);
        JwtRequest jwtRequest = JwtRequest.builder().username(USERNAME).password(PASSWORD).build();
        HttpEntity<JwtRequest> entityAuth = new HttpEntity<>(jwtRequest, null);
        HttpEntity<JwtResponse> authenticate = restTemplate.exchange(url + "/authenticate", HttpMethod.POST, entityAuth, JwtResponse.class);
        assertNotNull(authenticate);
        String accessToken = authenticate.getBody().getJwttoken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+accessToken);
        entity = new HttpEntity<>(null, headers);

        ResponseEntity<Goal[]> exchange = restTemplate.exchange(url + "/goals/by-user/", HttpMethod.GET, entity, Goal[].class);
        assertEquals(exchange.getStatusCode(), HttpStatus.OK);
        assertEquals(2, exchange.getBody().length);
    }

}
