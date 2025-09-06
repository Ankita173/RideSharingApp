package com.example.ridesharing.service;

import com.example.ridesharing.model.user.rating.UserRating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingService {

    private final Map<String, List<UserRating>> ratings = new HashMap<>();

    public void giveRating(UserRating rating) {
        ratings.computeIfAbsent(rating.getGivenTo(), k -> new ArrayList<>()).add(rating);
        System.out.println("⭐ " + rating.getGivenBy() + " rated " + rating.getGivenTo()
                + " with " + rating.getScore() + " stars. Feedback: " + rating.getFeedback());
    }

    public double getAverageRating(String userId) {
        List<UserRating> userRatings = ratings.getOrDefault(userId, new ArrayList<>());
        if (userRatings.isEmpty()) return 0.0;
        return userRatings.stream().mapToInt(UserRating::getScore).average().orElse(0.0);
    }

    public List<UserRating> getRatingsForUser(String userId) {
        return ratings.getOrDefault(userId, new ArrayList<>());
    }
}
