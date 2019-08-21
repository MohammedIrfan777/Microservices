package io.learning365.ratingdataservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.learning365.model.Rating;
import io.learning365.model.UserRating;

@RestController
@RequestMapping("/ratingdata")
public class RatingResourse {
	
	@RequestMapping("/{movieId}")
	public Rating getMovieInfo(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		
		List<Rating> ratings = Arrays.asList(
				new Rating("1234", 4),
				new Rating("7865", 5)
				);
		
		UserRating userrating = new UserRating();
		userrating.setUserRaing(ratings);
		return userrating;
	}

}
