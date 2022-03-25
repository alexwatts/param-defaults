package com.alwa.param;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class LocalDateTimeTest {

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
    public void testLocalDateTimeMin() {
        ResponseEntity<LocalDateTime> exchange = testRestTemplate.exchange("/params/local-date-time-min", HttpMethod.GET, new HttpEntity<>(null, headers), LocalDateTime.class);
        assertThat(exchange.getBody(), equalTo(LocalDateTime.MIN));
    }

    @Test
    public void testLocalDateTimeMax() {
        ResponseEntity<LocalDateTime> exchange = testRestTemplate.exchange("/params/local-date-time-max", HttpMethod.GET, new HttpEntity<>(null, headers), LocalDateTime.class);
        assertThat(exchange.getBody(), equalTo(LocalDateTime.MAX));
    }

    @Test
    public void testLocalDateTimeNow() {
        ResponseEntity<LocalDateTime> exchange = testRestTemplate.exchange("/params/local-date-time-now", HttpMethod.GET, new HttpEntity<>(null, headers), LocalDateTime.class);
        assertDatesClose(exchange.getBody(), LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()), 5);
    }

    private void assertDatesClose(LocalDateTime actual, LocalDateTime expected, int rangeSeconds) {
        assertThat(actual, greaterThan(expected.minusSeconds(rangeSeconds)));
        assertThat(actual, lessThan(expected.plusSeconds(rangeSeconds)));
    }

}
