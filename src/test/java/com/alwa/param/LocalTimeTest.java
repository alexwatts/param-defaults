package com.alwa.param;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalTime;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class LocalTimeTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private HttpHeaders headers;

    @BeforeEach
    public void setUp() {
        headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testLocalTimeMin() {
        ResponseEntity<LocalTime> exchange = testRestTemplate.exchange("/params/local-time-min", HttpMethod.GET, new HttpEntity<>(null, headers), LocalTime.class);
        assertThat(exchange.getBody(), equalTo(LocalTime.MIN));
    }

    @Test
    public void testLocalTimeMax() {
        ResponseEntity<LocalTime> exchange = testRestTemplate.exchange("/params/local-time-max", HttpMethod.GET, new HttpEntity<>(null, headers), LocalTime.class);
        assertThat(exchange.getBody(), equalTo(LocalTime.MAX));
    }

    @Test
    public void testLocalTimeMidnight() {
        ResponseEntity<LocalTime> exchange = testRestTemplate.exchange("/params/local-time-midnight", HttpMethod.GET, new HttpEntity<>(null, headers), LocalTime.class);
        assertThat(exchange.getBody(), equalTo(LocalTime.MIDNIGHT));
    }

    @Test
    public void testLocalTimeNoon() {
        ResponseEntity<LocalTime> exchange = testRestTemplate.exchange("/params/local-time-noon", HttpMethod.GET, new HttpEntity<>(null, headers), LocalTime.class);
        assertThat(exchange.getBody(), equalTo(LocalTime.NOON));
    }

}
