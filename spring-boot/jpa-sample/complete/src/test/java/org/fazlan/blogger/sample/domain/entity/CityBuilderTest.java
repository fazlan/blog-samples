package org.fazlan.blogger.sample.domain.entity;


import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fazlan.blogger.sample.domain.fixture.CityFixture.*;

public class CityBuilderTest {

    @Test
    public void builds_city_entity_given_name_state_and_country() throws Exception {

        //when:
        City city = City.builder(CITY_MELBOURNE, COUNTRY_AUSTRALIA).state(STATE_VICTORIA).build();

        //then:
        assertThat(city).isNotNull();
        assertThat(city.getName()).isSameAs(CITY_MELBOURNE);
        assertThat(city.getState()).isSameAs(STATE_VICTORIA);
        assertThat(city.getCountry()).isSameAs(COUNTRY_AUSTRALIA);
    }
}
