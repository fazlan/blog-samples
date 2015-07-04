package org.fazlan.blogger.sample.domain.spec;

import org.fazlan.blogger.sample.domain.entity.City;
import org.fazlan.blogger.sample.domain.entity.City_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

class CityByNameCountry extends CitySpec {

    CityByNameCountry(City city) {
        super(city);
    }

    @Override
    public Predicate toPredicate(Root<City> city, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.and(
                cb.equal(city.get(City_.name), criteria.getName()),
                cb.equal(city.get(City_.country), criteria.getCountry())
        );
    }

}
