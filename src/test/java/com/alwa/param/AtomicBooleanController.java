package com.alwa.param;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@RequestMapping(value = "/params")
public class AtomicBooleanController {

    @GetMapping("/atomic-boolean-true")
    public ResponseEntity atomicBooleanTrue(
            @RequestParam(
                    defaultValue = "#{${DEFAULTS.AtomicBoolean.TRUE}}",
                    required = false
            ) AtomicBoolean atomicBoolean
    ) {
        return ResponseEntity.ok(atomicBoolean);
    }

    @GetMapping("/atomic-boolean-false")
    public ResponseEntity atomicBooleanFalse(
            @RequestParam(
                    defaultValue = "#{${DEFAULTS.AtomicBoolean.FALSE}}",
                    required = false
            ) AtomicBoolean atomicBoolean
    ) {
        return ResponseEntity.ok(atomicBoolean);
    }

}