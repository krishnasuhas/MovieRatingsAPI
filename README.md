# MovieRatingsAPI
This API will provide the ratings of the movie's watched by registered user's

Created 3 different following microService's:

1) MovieCatalog - Main Api to get list of movie's and it's rating's given by that user
2) MovieInfo - this will give movieInfo if you pass movieId
3) RatingsData - this will give rating's if you provide movieId with UserId


Note: everything is hardCoded no connection to any DB

TechStack:
1) SpringBoot - for creating MicroService's
2) Eureka - for discovering service's url instead of hardCoding when one service want to call another service
3) Hystrix - In order to handle any fault's like providing default response in case any dependent Server is down

DesignPattern's used:
BulkHead - while implementing Fault Tolerant to restrict num of threads for each call


