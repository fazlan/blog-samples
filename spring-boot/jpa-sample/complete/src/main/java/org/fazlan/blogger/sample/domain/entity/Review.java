package org.fazlan.blogger.sample.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "REVIEWS",
        uniqueConstraints = @UniqueConstraint(columnNames = {"HOTEL_ID", "GUEST_ID"}))
public class Review implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "REVIEW_ID", nullable = false, unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HOTEL_ID", nullable = false)
    private final Hotel hotel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GUEST_ID", nullable = false)
    private final Guest guest;

    @Column(name = "RATING")
    private final Rating rating;

    @SuppressWarnings("unused")
    private Review() {
        /* Required by JPA */
        this(builder(null, null));
    }

    private Review(Builder builder) {
        this.hotel = builder.hotel;
        this.guest = builder.guest;
        this.rating = builder.rating;
    }

    public Long getId() {
        return id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Guest getGuest() {
        return guest;
    }

    public Rating getRating() {
        return rating;
    }

    public static Builder builder(Hotel hotel, Guest guest) {
        return new Builder(hotel, guest);
    }

    public enum Rating { BAD, AVERAGE, GOOD}

    public static class Builder {

        private final Hotel hotel;
        private final Guest guest;
        private Rating rating;

        private Builder(Hotel hotel, Guest guest) {
            this.hotel = hotel;
            this.guest = guest;
            this.rating = Rating.AVERAGE;
        }

        public Builder rating(Rating rating) {
            this.rating = rating;
            return this;
        }

        public Review build() {
            Review review = new Review(this);
            hotel.getReviews().add(review);
            guest.getReviews().add(review);
            return review;
        }
    }
}