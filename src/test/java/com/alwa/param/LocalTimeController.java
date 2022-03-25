package com.alwa.param;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
@RequestMapping(value = "/params")
public class LocalTimeController {


    @GetMapping("/local-time-min")
    public ResponseEntity localDateTimeMin(
            @RequestParam(
                    defaultValue = "#{${DEFAULTS.LocalTime.MIN}}",
                    required = false
            ) LocalTime min
    ) {
        return ResponseEntity.ok(min);
    }

    @GetMapping("/local-time-max")
    public ResponseEntity localDateTimeMax(
            @RequestParam(
                    defaultValue = "#{${DEFAULTS.LocalTime.MAX}}",
                    required = false
            ) LocalTime max
    ) {
        return ResponseEntity.ok(max);
    }


    @GetMapping("/local-time-midnight")
    public ResponseEntity localDateTimeMidnight(
            @RequestParam(
                    defaultValue = "#{${DEFAULTS.LocalTime.MIDNIGHT}}",
                    required = false
            ) LocalTime midnight
    ) {
        return ResponseEntity.ok(midnight);
    }


    @GetMapping("/local-time-noon")
    public ResponseEntity localDateTimeNoon(
            @RequestParam(
                    defaultValue = "#{${DEFAULTS.LocalTime.NOON}}",
                    required = false
            ) LocalTime noon
    ) {
        return ResponseEntity.ok(noon);
    }

}