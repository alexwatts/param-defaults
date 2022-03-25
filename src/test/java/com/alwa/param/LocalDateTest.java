package com.alwa.param;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class LocalDateTest {

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
    public void testLocalDateMin() {
        ResponseEntity<LocalDate> exchange = testRestTemplate.exchange("/params/local-date-min", HttpMethod.GET, new HttpEntity<>(null, headers), LocalDate.class);
        assertThat(exchange.getBody(), equalTo(LocalDate.MIN));
    }

    @Test
    public void testLocalDateMax() {
        ResponseEntity<LocalDate> exchange = testRestTemplate.exchange("/params/local-date-max", HttpMethod.GET, new HttpEntity<>(null, headers), LocalDate.class);
        assertThat(exchange.getBody(), equalTo(LocalDate.MAX));
    }

    @Test
    public void testLocalDateEpoch() {
        ResponseEntity<LocalDate> exchange = testRestTemplate.exchange("/params/local-date-epoch", HttpMethod.GET, new HttpEntity<>(null, headers), LocalDate.class);
        assertThat(exchange.getBody(), equalTo(LocalDate.EPOCH));
    }

}
