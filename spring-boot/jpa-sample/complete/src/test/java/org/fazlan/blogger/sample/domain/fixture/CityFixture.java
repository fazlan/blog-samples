package org.fazlan.blogger.sample.domain.fixture;

import org.fazlan.blogger.sample.domain.entity.City;

public class CityFixture {

    private CityFixture() {}

    public static final String CITY_MELBOURNE = "Melbourne";
    public static final String CITY_SYDNEY = "Sydney";
    public static final String STATE_NSW = "NSW";
    public static final String STATE_VICTORIA = "Victoria";
    public static final String COUNTRY_AUSTRALIA = "Australia";

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