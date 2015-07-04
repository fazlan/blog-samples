package org.fazlan.blogger.sample.domain.fixture;

import org.fazlan.blogger.sample.domain.entity.City;
import org.springframework.data.jpa.domain.Specification;

public class CitySpecFactory {

    private CitySpecFactory() {}

    public static Specification<City> byNameAndCountry(City city) {
        return new CityByNameCountry(city);
    }

    public static Specification<City> byCountry(City city) {
        return new CityByCountry(city);
    }
}