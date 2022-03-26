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
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class UUIDTest {

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
    public void testUUIDRandom() {
        ResponseEntity<UUID> exchange = testRestTemplate.exchange("/params/uuid-random", HttpMethod.GET, new HttpEntity<>(null, headers), UUID.class);
        assertUUID(exchange.getBody(), UUID.randomUUID());
    }

    private void assertUUID(UUID actual, UUID expected) {
        assertThat(actual, notNullValue());
        assertThat(actual.toString().length(), equalTo(expected.toString().length()));
    }


}
