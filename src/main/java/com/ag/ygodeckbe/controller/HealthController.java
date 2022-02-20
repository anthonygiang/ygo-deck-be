package com.ag.ygodeckbe.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("health")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HealthController {

    @GetMapping
    public ResponseEntity getHealth(@RequestHeader(value = "User-Agent") String userAgent) {
        return ResponseEntity.ok("Healthy");
    }

}
