package org.fazlan.blogger.sample.domain.repo;

import org.fazlan.blogger.sample.domain.DomainTestConfig;
import org.fazlan.blogger.sample.domain.entity.Guest;
import org.fazlan.blogger.sample.domain.fixture.GuestFixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("int")
@SpringApplicationConfiguration(classes = DomainTestConfig.class)
public class GuestRepositoryITSpec extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private GuestRepository repository;

    private Guest johnSmith;

    @BeforeMethod
    public void beforeEachTest() {
        johnSmith = GuestFixture.getJohnSmith();
    }

    @Test
    public void creates_hotel_given_name() {
        //when:
        Long guestId = repository.save(johnSmith).getId();

        //then:
        assertThat(repository.getOne(guestId)).isEqualTo(johnSmith);
    }
}
