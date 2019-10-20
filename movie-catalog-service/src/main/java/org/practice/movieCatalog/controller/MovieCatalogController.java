package org.practice.movieCatalog.controller;

import org.practice.movieCatalog.service.MovieInfoService;
import org.practice.movieCatalog.service.RatingsDataService;
import org.practice.movieCatalog.model.CatalogItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/MovieCatalog")
public class MovieCatalogController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private MovieInfoService movieInfoService;

    @Autowired
    private RatingsDataService ratingsDataService;

    @GetMapping(value = "/getList/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {
        List<String> movieIds = Arrays.asList("1", "2", "3", "4", "5");
        return movieIds.stream()
                .map(i -> {
                    String movie = movieInfoService.getMovie(i);
                    Integer rating = ratingsDataService.getRating(i);
                    /* Using WebClient to support Asynchronous call to any api and also better than restTemplate
                    String movie = webClientBuilder.build()
                            .get()
                            .uri("http://localhost:8082/MovieInfo/" + i)
                            .retrieve()
                            .bodyToMono(String.class)
                            .block();
                    Integer rating = webClientBuilder.build()
                            .get()
                            .uri("http://localhost:8083/Ratings/" + i)
                            .retrieve()
                            .bodyToMono(Integer.class)
                            .block();*/
                    if (movie == null || rating == null) return null;
                    return new CatalogItem(movie, "good Movie", rating);
                }).collect(Collectors.toList());
    }
}