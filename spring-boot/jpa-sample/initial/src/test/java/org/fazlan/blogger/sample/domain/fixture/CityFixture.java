package org.fazlan.blogger.sample.domain.fixture;

import org.fazlan.blogger.sample.domain.entity.City;

public class CityFixture {

    private CityFixture() {}

    static final String CITY_MELBOURNE = "Melbourne";
    static final String CITY_SYDNEY = "Sydney";
    static final String STATE_NSW = "NSW";
    static final String STATE_VICTORIA = "Victoria";
    static final String COUNTRY_AUSTRALIA = "Australia";

    public static City getMelbourne() {
        return City.builder(CITY_MELBOURNE, COUNTRY_AUSTRALIA).state(STATE_VICTORIA).build();
    }

    public static City getSydney() {
        return City.builder(CITY_SYDNEY, COUNTRY_AUSTRALIA).state(STATE_NSW).build();
    }

    public static City getAustralianCities() {
        return City.builder(null, COUNTRY_AUSTRALIA).build();
    }
}