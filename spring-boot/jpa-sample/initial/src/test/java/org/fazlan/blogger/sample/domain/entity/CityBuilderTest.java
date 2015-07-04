package org.fazlan.blogger.sample.domain.entity;


import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CityBuilderTest {

    @Test
    public void builds_city_entity_given_name_state_and_country() throws Exception {
        //given:
        String name = "Melbourne";
        String state = "Victoria";
        String country = "Australia";

        //when:
        City city = City.builder(name,country).state(state).build();

        //then:
        assertThat(city).isNotNull();
        assertThat(city.getName()).isEqualTo(name);
        assertThat(city.getState()).isEqualTo(state);
        assertThat(city.getCountry()).isEqualTo(country);
    }
}
