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
import java.util.concurrent.atomic.AtomicLong;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class AtomicLongTest {

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
    public void testAtomicLongMin() {
        ResponseEntity<AtomicLong> exchange = testRestTemplate.exchange("/params/atomic-long-min", HttpMethod.GET, new HttpEntity<>(null, headers), AtomicLong.class);
        assertThat(exchange.getBody().longValue(), equalTo(new AtomicLong(Long.MIN_VALUE).longValue()));
    }

    @Test
    public void testAtomicLongMax() {
        ResponseEntity<AtomicLong> exchange = testRestTemplate.exchange("/params/atomic-long-max", HttpMethod.GET, new HttpEntity<>(null, headers), AtomicLong.class);
        assertThat(exchange.getBody().longValue(), equalTo(new AtomicLong(Long.MAX_VALUE).longValue()));
    }

}
