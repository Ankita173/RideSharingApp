package com.example.ridesharing.controller;

import com.example.ridesharing.model.user.rating.UserRating;
import com.example.ridesharing.service.RatingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private RatingService ratingService;

    @PostMapping
    public String giveRating(@RequestBody UserRating rating) {
        ratingService.giveRating(rating);
        return "Rating submitted successfully!";
    }
}
