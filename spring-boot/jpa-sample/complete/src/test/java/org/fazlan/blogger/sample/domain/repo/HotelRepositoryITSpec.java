package org.fazlan.blogger.sample.domain.repo;

import org.fazlan.blogger.sample.domain.entity.Hotel;
import org.fazlan.blogger.sample.domain.fixture.HotelFixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@RepositoryIntegration
public class HotelRepositoryITSpec extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private HotelRepository repository;

    private Hotel crown;

    @BeforeMethod
    public void beforeEachTest() {
        crown = HotelFixture.getCrownHotel();
    }

    @Test
    public void creates_hotel_given_name() {
        //when:
        Long hotelId = repository.save(crown).getId();

        //then:
        assertThat(repository.getOne(hotelId)).isEqualTo(crown);
    }
}
