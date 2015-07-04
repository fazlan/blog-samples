package org.fazlan.blogger.sample.domain.entity;


import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fazlan.blogger.sample.domain.fixture.GuestFixture.GUEST_JOHN_SMITH;

public class GuestBuilderTest {

    @Test
    public void builds_guest_entity_given_name() throws Exception {
        //when:
        Guest guest = Guest.builder(GUEST_JOHN_SMITH).build();

        //then:
        assertThat(guest).isNotNull();
        assertThat(guest.getName()).isSameAs(GUEST_JOHN_SMITH);
    }
}
