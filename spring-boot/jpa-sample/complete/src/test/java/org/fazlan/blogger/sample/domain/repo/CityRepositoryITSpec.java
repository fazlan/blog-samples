package org.fazlan.blogger.sample.domain.repo;

import org.fazlan.blogger.sample.domain.DomainTestConfig;
import org.fazlan.blogger.sample.domain.entity.City;
import org.fazlan.blogger.sample.domain.fixture.CityFixture;
import org.fazlan.blogger.sample.domain.spec.CitySpecFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("int")
@SpringApplicationConfiguration(classes = DomainTestConfig.class)
public class CityRepositoryITSpec extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private CityRepository repository;

    private City melbourne;

    @BeforeMethod
    public void beforeEachTest() {
        melbourne = CityFixture.getMelbourne();
    }

    @Test
    public void creates_city_given_name_and_state_country() {
        //when:
        Long cityId = repository.save(melbourne).getId();

        //then:
        assertThat(repository.getOne(cityId)).isEqualTo(melbourne);
    }

    @Test
    public void finds_city_given_name_and_country() {
        //given:
        repository.save(melbourne);

        //when:
        City result  = repository.findOne(CitySpecFactory.byNameAndCountry(melbourne));

        //then:
        assertThat(result).isEqualTo(melbourne);
    }

    @Test
    public void finds_all_cities_given_country() {
        //given:
        City sydney = CityFixture.getSydney();
        repository.save(Arrays.asList(melbourne, sydney));

        //when:
        List<City> results  = repository.findAll(CitySpecFactory.byCountry(CityFixture.getAustralianCities()));

        //then:
        assertThat(results).containsAll(Arrays.asList(melbourne, sydney));
    }
}
