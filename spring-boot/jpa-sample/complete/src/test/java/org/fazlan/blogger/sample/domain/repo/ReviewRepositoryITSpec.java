package org.fazlan.blogger.sample.domain.repo;

import org.fazlan.blogger.sample.domain.DomainTestConfig;
import org.fazlan.blogger.sample.domain.entity.Guest;
import org.fazlan.blogger.sample.domain.entity.Hotel;
import org.fazlan.blogger.sample.domain.entity.Review;
import org.fazlan.blogger.sample.domain.fixture.GuestFixture;
import org.fazlan.blogger.sample.domain.fixture.HotelFixture;
import org.fazlan.blogger.sample.domain.fixture.ReviewFixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fazlan.blogger.sample.domain.entity.Review.Rating;

@ActiveProfiles("int")
@SpringApplicationConfiguration(classes = DomainTestConfig.class)
public class ReviewRepositoryITSpec extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private GuestRepository guestRepository;

    private Hotel crown;
    private Guest john;

    @BeforeMethod
    public void beforeEachTest() {
        crown = HotelFixture.getCrownHotel();
        john = GuestFixture.getJohnSmith();
    }

    @Test
    public void creates_a_good_review_for_crown_hotel_by_guest_john_smith_and_links_to_hotel_and_guest() {
        //given:
        Review review = ReviewFixture.getGoodReview(crown, john);

        //when:
        Long reviewId = repository.save(review).getId();

        //then:
        review = repository.getOne(reviewId);

        assertThatReview(review, Rating.GOOD);
    }

    @Test
    public void creates_a_good_review_for_persisted_crown_hotel_by_guest_john_smith_and_links_to_hotel_and_guest() {
        //given:
        hotelRepository.save(crown);
        guestRepository.save(john);
        //and:
        Review review = ReviewFixture.getGoodReview(crown, john);

        //when:
        Long reviewId = repository.save(review).getId();

        //then:
        review = repository.getOne(reviewId);

        assertThatReview(review, Rating.GOOD);
    }


    private void assertThatReview(Review review, Rating average) {
        assertThat(review).isNotNull();
        assertThat(review.getRating()).isEqualTo(average);

        assertThat(review.getHotel()).isEqualTo(crown);
        assertThat(review.getGuest()).isEqualTo(john);

        assertThat(crown.getReviews()).contains(review);
        assertThat(john.getReviews()).contains(review);
    }
}
