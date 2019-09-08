Spring Boot Micro services Movies details.

# Discovery-server.
Its Eureka Server which have all micro service to discover.

# Movie Catalog service.
Which will take movieid and userid from MOVIE INFO SERVICE and RATING DATA SERVICE and displays the catalog rating data.

# Movie Info service.
Contains the movie information "reviews".

# Rating Data Service.
Contains the movie details and its rating.

Each Microservices run independently and communicates each other. 
Implemented the circuit breaker problem called #hystrix 
Hystrix dashboard.



