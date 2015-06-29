package org.fazlan.blogger.sample.domain.repo;

import org.fazlan.blogger.sample.domain.entity.City;

class CityRepositoryFixture {

    static final String CITY_MELBOURNE = "Melbourne";
    static final String CITY_SYDNEY = "Sydney";
    static final String STATE_NSW = "NSW";
    static final String STATE_VICTORIA = "Victoria";
    static final String COUNTRY_AUSTRALIA = "Australia";

    static City getMelbourne() {
        return City.builder(CITY_MELBOURNE, COUNTRY_AUSTRALIA).state(STATE_VICTORIA).build();
    }

    static City getSydney() {
        return City.builder(CITY_SYDNEY, COUNTRY_AUSTRALIA).state(STATE_NSW).build();
    }

    static City getAustralianCities() {
        return City.builder(null, COUNTRY_AUSTRALIA).build();
    }
}