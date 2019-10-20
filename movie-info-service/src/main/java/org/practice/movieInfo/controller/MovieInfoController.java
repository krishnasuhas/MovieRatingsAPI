package org.practice.movieInfo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/MovieInfo")
public class MovieInfoController {

    Map<String, String> map = new HashMap<>();

    @GetMapping("/{movieId}")
    public String getMovie(@PathVariable String movieId) {
        map.put("1", "m-a");
        map.put("2", "m-b");
        map.put("3", "m-c");
        map.put("4", "m-d");
        map.put("5", "m-e");
        return map.getOrDefault(movieId, "Default");
    }
}
