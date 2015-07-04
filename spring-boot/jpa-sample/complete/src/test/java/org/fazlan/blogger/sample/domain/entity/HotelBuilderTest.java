package org.fazlan.blogger.sample.domain.entity;


import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fazlan.blogger.sample.domain.fixture.HotelFixture.HOTEL_CROWN;

public class HotelBuilderTest {

    @Test
    public void builds_hotel_entity_given_name() throws Exception {
        //when:
        Hotel city = Hotel.builder(HOTEL_CROWN).build();

        //then:
        assertThat(city).isNotNull();
        assertThat(city.getName()).isSameAs(HOTEL_CROWN);
    }
}
