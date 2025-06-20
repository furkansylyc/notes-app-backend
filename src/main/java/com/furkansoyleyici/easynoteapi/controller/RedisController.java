package com.furkansoyleyici.easynoteapi.controller;

import com.furkansoyleyici.easynoteapi.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
@CrossOrigin(origins = "*")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @PostMapping("/save")
    public String save(@RequestParam String key, @RequestParam String value) {
        redisService.saveData(key, value);
        return "Saved key: " + key;
    }

    @GetMapping("/get")
    public String get(@RequestParam String key) {
        String value = redisService.getData(key);
        return value != null ? value : "Key not found.";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam String key) {
        redisService.deleteData(key);
        return "Deleted key: " + key;
    }
}
