package org.practice.ratingsData.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Ratings")
public class RatingsDataController {

    Map<String, Integer> map = new HashMap<>();

    @GetMapping("/{movieId}")
    public int getRating(@PathVariable String movieId) {
        map.put("1", 10);
        map.put("2", 20);
        map.put("3", 30);
        map.put("4", 40);
        map.put("5", 50);
        return map.getOrDefault(movieId, 0);
    }
}
