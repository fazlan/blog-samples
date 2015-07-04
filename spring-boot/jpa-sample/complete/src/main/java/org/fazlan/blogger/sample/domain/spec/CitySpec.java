package org.fazlan.blogger.sample.domain.spec;

import org.fazlan.blogger.sample.domain.entity.City;
import org.springframework.data.jpa.domain.Specification;

abstract class CitySpec implements Specification<City> {

    protected final City criteria;

    protected CitySpec(City city) {
        this.criteria = city;
    }
}
