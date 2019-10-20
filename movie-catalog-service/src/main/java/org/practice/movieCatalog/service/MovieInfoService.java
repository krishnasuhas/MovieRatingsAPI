package org.practice.movieCatalog.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getMovieFallback",
            threadPoolKey = "movieInfoThreadPool", //bulkHeadPattern for fixing max threads allowed for this call in waiting
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            })
    public String getMovie(String userId) {
        return restTemplate.getForObject("http://MOVIE-INFO/MovieInfo/" + userId, String.class);
    }

    public String getMovieFallback(String userId) {
        return "No Movie Found";
    }
}
