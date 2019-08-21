package io.learning365.movieinfoservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.learning365.model.Movie;


@RestController
@RequestMapping("/movies")
public class MovieResourse {
	
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		return new Movie(movieId, "Transformers");
	}

}
