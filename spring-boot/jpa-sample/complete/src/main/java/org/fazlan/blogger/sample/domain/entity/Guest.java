package org.fazlan.blogger.sample.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "GUESTS")
public class Guest implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "GUEST_ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private final String name;

    @OneToMany(mappedBy = "guest")
    private final Set<Review> reviews;

    @SuppressWarnings("unused")
    private Guest() {
        /* Required by JPA */
        this(builder(null));
    }

    private Guest(Builder builder) {
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

        public Guest build() {
            return new Guest(this);
        }
    }
}