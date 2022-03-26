package com.alwa.param;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/params")
public class AtomicLongController {


    @GetMapping("/atomic-long-min")
    public ResponseEntity atomicLongMin(
            @RequestParam(
                    defaultValue = "#{${DEFAULTS.AtomicLong.MIN}}",
                    required = false
            ) AtomicLong atomicLong
    ) {
        return ResponseEntity.ok(atomicLong);
    }

    @GetMapping("/atomic-long-max")
    public ResponseEntity atomicLongMax(
            @RequestParam(
                    defaultValue = "#{${DEFAULTS.AtomicLong.MAX}}",
                    required = false
            ) AtomicLong atomicLong
    ) {
        return ResponseEntity.ok(atomicLong);
    }

}