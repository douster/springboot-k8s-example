package com.maryanto.dimas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HaloController {

    @GetMapping("/hello")
    public ResponseEntity<Map> halo() {
        Map<String, Object> param = new HashMap<>();
        param.put("message", "Hello kubernates (k8s)");
        return ResponseEntity.ok(param);
    }
}
