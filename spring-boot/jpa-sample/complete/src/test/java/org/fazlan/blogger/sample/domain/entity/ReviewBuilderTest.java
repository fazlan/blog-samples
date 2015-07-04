package org.fazlan.blogger.sample.domain.entity;


import org.fazlan.blogger.sample.domain.fixture.GuestFixture;
import org.fazlan.blogger.sample.domain.fixture.HotelFixture;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fazlan.blogger.sample.domain.entity.Review.Rating;

public class ReviewBuilderTest {

    private Hotel crown;
    private Guest john;

    @BeforeMethod
    public void beforeEachTest() {
        //given:
        crown = HotelFixture.getCrownHotel();
        john = GuestFixture.getJohnSmith();
    }

    @Test
    public void builds_average_review_given_hotel_by_guest() throws Exception {
        //when:
        Review review = Review.builder(crown, john).build();

        //then:
        assertThatReview(review, Rating.AVERAGE);
    }

    @Test
    public void builds_review_for_hotel_given_by_guest_review() throws Exception {
        //when:
        Review review = Review.builder(crown, john).rating(Rating.GOOD).build();

        //then:
        assertThatReview(review, Rating.GOOD);
    }

    private void assertThatReview(Review review, Rating average) {
        assertThat(review).isNotNull();
        assertThat(review.getHotel()).isSameAs(crown);
        assertThat(review.getGuest()).isSameAs(john);
        assertThat(review.getRating()).isEqualTo(average);
    }
}
