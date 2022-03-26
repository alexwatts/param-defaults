package com.alwa.param;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class AtomicIntegerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private HttpHeaders headers;

    @BeforeEach
    public void setUp() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testAtomicBooleanTrue() {
        ResponseEntity<AtomicInteger> exchange = testRestTemplate.exchange("/params/atomic-integer-min", HttpMethod.GET, new HttpEntity<>(null, headers), AtomicInteger.class);
        assertThat(exchange.getBody().get(), equalTo(new AtomicInteger(Integer.MIN_VALUE).get()));
    }

    @Test
    public void testAtomicBooleanFalse() {
        ResponseEntity<AtomicInteger> exchange = testRestTemplate.exchange("/params/atomic-integer-max", HttpMethod.GET, new HttpEntity<>(null, headers), AtomicInteger.class);
        assertThat(exchange.getBody().get(), equalTo(new AtomicInteger(Integer.MAX_VALUE).get()));
    }

}
