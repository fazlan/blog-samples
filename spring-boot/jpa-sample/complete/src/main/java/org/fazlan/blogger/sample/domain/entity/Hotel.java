package org.fazlan.blogger.sample.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "HOTELS")
public class Hotel implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "HOTEL_ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private final String name;

    @OneToMany(mappedBy = "hotel")
    private final Set<Review> reviews;

    @SuppressWarnings("unused")
    private Hotel() {
        /* Required by JPA */
        this(builder(null));
    }

    private Hotel(Builder builder) {
        this.name = builder.name;
        this.reviews = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public static Builder builder(String name) {
        return new Builder(name);
    }

    public static class Builder {
        private String name;

        private Builder(String name) {
            this.name = name;
        }

        public Hotel build() {
            return new Hotel(this);
        }
    }
}