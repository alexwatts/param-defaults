package com.alwa.param;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@RequestMapping(value = "/params")
public class UUIDController {


    @GetMapping("/uuid-random")
    public ResponseEntity uuidRandom(
            @RequestParam(
                    defaultValue = "#{${DEFAULTS.UUID.RANDOM}}",
                    required = false
            ) UUID uuid
    ) {
        return ResponseEntity.ok(uuid);
    }

}