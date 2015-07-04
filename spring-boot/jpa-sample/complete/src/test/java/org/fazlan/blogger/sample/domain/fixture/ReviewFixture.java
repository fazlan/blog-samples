package org.fazlan.blogger.sample.domain.fixture;

import org.fazlan.blogger.sample.domain.entity.Guest;
import org.fazlan.blogger.sample.domain.entity.Hotel;
import org.fazlan.blogger.sample.domain.entity.Review;

import static org.fazlan.blogger.sample.domain.entity.Review.Rating;

public class ReviewFixture {
    private ReviewFixture() {}

    public static Review getGoodReview(Hotel hotel, Guest guest) {
        return Review.builder(hotel, guest).rating(Rating.GOOD).build();
    }
}
