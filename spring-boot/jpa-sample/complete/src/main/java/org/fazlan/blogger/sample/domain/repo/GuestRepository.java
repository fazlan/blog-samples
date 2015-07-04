package org.fazlan.blogger.sample.domain.repo;

import org.fazlan.blogger.sample.domain.entity.Guest;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends EntityJpaRepository<Guest, Long> {
}


