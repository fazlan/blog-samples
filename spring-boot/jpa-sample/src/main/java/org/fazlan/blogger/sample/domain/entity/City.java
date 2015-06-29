package org.fazlan.blogger.sample.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CITIES")
public class City implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "CITY_ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private final String name;

    @Column(name = "STATE", nullable = false)
    private final String state;

    @Column(name = "COUNTRY", nullable = false)
    private final String country;

    @SuppressWarnings("unused")
    private City() {
        this(builder(null, null));
    }

    private City(Builder builder) {
        this.name = builder.name;
        this.state = builder.state;
        this.country = builder.country;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public static Builder builder(String name, String country) {
        return new Builder(name, country);
    }

    public static class Builder {
        private String name;
        private String state;
        private String country;

        public Builder(String name, String country) {
            this.name = name;
            this.country = country;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public City build() {
            return new City(this);
        }
    }
}