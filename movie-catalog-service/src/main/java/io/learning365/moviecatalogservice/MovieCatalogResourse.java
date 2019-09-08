package io.learning365.moviecatalogservice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.learning365.model.CatalogItem;
import io.learning365.model.Movie;
import io.learning365.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResourse {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	@HystrixCommand(fallbackMethod="getFallbackCatalog")
	public List<CatalogItem> getCatalogItem(@PathVariable("userId") String userId) {

		UserRating userRating = restTemplate.getForObject("http://rating-data-service/ratingdata/users/"+userId, UserRating.class);


		return userRating.getUserRaing().stream().map(rating -> {
			Movie  movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/"+rating.getMovieId(), Movie.class);
			return new CatalogItem( movie.getName() , "Good", rating.getRating());
		}).collect(Collectors.toList());



	}


	public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String userId) {

		//better to pick from cache
		return Arrays.asList(new CatalogItem("demo name", "desc", 4));



	}
}
