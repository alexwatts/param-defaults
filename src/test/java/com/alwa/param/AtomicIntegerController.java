package com.alwa.param;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping(value = "/params")
public class AtomicIntegerController {


    @GetMapping("/atomic-integer-min")
    public ResponseEntity atomicIntegerMin(
            @RequestParam(
                    defaultValue = "#{${DEFAULTS.AtomicInteger.MIN}}",
                    required = false
            ) AtomicInteger atomicInteger
    ) {
        return ResponseEntity.ok(atomicInteger);
    }

    @GetMapping("/atomic-integer-max")
    public ResponseEntity atomicIntegerMax(
            @RequestParam(
                    defaultValue = "#{${DEFAULTS.AtomicInteger.MAX}}",
                    required = false
            ) AtomicInteger atomicInteger
    ) {
        return ResponseEntity.ok(atomicInteger);
    }

}