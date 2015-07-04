package org.fazlan.blogger.sample.domain.repo;

import org.fazlan.blogger.sample.domain.entity.Hotel;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends EntityJpaRepository<Hotel, Long> {
}


