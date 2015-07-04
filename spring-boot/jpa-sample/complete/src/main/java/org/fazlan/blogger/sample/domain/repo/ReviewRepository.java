package org.fazlan.blogger.sample.domain.repo;

import org.fazlan.blogger.sample.domain.entity.Review;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends EntityJpaRepository<Review, Long> {
}


