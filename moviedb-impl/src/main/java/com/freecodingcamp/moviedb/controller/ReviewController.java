package com.freecodingcamp.moviedb.controller;

import com.freecodingcamp.movie.api.ReviewAPIs;
import com.freecodingcamp.movie.views.ReviewView;
import com.freecodingcamp.moviedb.exceptions.IMDBIdNotFoundException;
import com.freecodingcamp.moviedb.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.InvalidPropertiesFormatException;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController implements ReviewAPIs {

    @Autowired
    ReviewService reviewService;

    @Override
    public ResponseEntity addReview(ReviewView reviewView, String imdbId) {
        try {
            reviewService.addReview(reviewView, imdbId);
        } catch (IMDBIdNotFoundException | InvalidPropertiesFormatException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
