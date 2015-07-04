package org.fazlan.blogger.sample.domain.repo;

import org.fazlan.blogger.sample.domain.entity.City;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends EntityJpaRepository<City, Long> {
}


