package com.alwa.param;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/params")
public class LocalDateTimeController {


    @GetMapping("/local-date-time-min")
    public ResponseEntity localDateTimeMin(
            @RequestParam(
                    defaultValue = "#{${DEFAULTS.LocalDateTime.MIN}}",
                    required = false
            ) LocalDateTime min
    ) {
        return ResponseEntity.ok(min);
    }

    @GetMapping("/local-date-time-max")
    public ResponseEntity localDateMax(
            @RequestParam(
                    defaultValue = "#{${DEFAULTS.LocalDateTime.MAX}}",
                    required = false
            ) LocalDateTime max
    ) {
        return ResponseEntity.ok(max);
    }

    @GetMapping("/local-date-time-now")
    public ResponseEntity localDateNow(
            @RequestParam(
                    defaultValue = "#{${DEFAULTS.LocalDateTime.NOW}}",
                    required = false
            ) LocalDateTime now
    ) {
        return ResponseEntity.ok(now);
    }

}