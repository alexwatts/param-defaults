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
import java.util.concurrent.atomic.AtomicBoolean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class AtomicBooleanTest {

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
    public void testAtomicBooleanTrue() {
        ResponseEntity<AtomicBoolean> exchange = testRestTemplate.exchange("/params/atomic-boolean-true", HttpMethod.GET, new HttpEntity<>(null, headers), AtomicBoolean.class);
        assertThat(exchange.getBody().get(), equalTo(new AtomicBoolean(true).get()));
    }

    @Test
    public void testAtomicBooleanFalse() {
        ResponseEntity<AtomicBoolean> exchange = testRestTemplate.exchange("/params/atomic-boolean-false", HttpMethod.GET, new HttpEntity<>(null, headers), AtomicBoolean.class);
        assertThat(exchange.getBody().get(), equalTo(new AtomicBoolean(false).get()));
    }

}
