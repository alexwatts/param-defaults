package com.alwa.param;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/params")
public class LocalDateController {

    @GetMapping("/local-date-min")
    public ResponseEntity localDateMin(
            @RequestParam(
                    defaultValue = "#{${DEFAULTS.LocalDate.MIN}}",
                    required = false
            ) LocalDate min
    ) {
        return ResponseEntity.ok(min);
    }

    @GetMapping("/local-date-max")
    public ResponseEntity localDateMax(
            @RequestParam(
                    defaultValue = "#{${DEFAULTS.LocalDate.MAX}}",
                    required = false
            ) LocalDate max
    ) {
        return ResponseEntity.ok(max);
    }

    @GetMapping("/local-date-epoch")
    public ResponseEntity localDateEpoch(
            @RequestParam(
                    defaultValue = "#{${DEFAULTS.LocalDate.EPOCH}}",
                    required = false
            ) LocalDate epoch
    ) {
        return ResponseEntity.ok(epoch);
    }

}