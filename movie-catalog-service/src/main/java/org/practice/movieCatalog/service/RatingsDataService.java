package org.practice.movieCatalog.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RatingsDataService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getRatingFallback",
            threadPoolKey = "ratingsDataThreadPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            })
    public Integer getRating(String userId) {
        return restTemplate.getForObject("http://RATINGS-DATA/Ratings/" + userId, Integer.class);
    }

    /*commandProperties = {
                        @HystrixProperty(name = "execution.isolation.thread.timeInMilliseconds", value = "2000"),
                        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                        @HystrixProperty(name = "execution.errorThresholdPercentage", value = "50"),
                        @HystrixProperty(name = "execution.sleepWindowInMilliseconds", value = "5000")
                }*/
    public Integer getRatingFallback(String userId) {
        return 0;
    }
}
