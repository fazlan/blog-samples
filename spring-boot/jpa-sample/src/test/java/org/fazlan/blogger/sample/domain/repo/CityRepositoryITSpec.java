package org.fazlan.blogger.sample.domain.repo;

import org.fazlan.blogger.sample.domain.DomainTestConfig;
import org.fazlan.blogger.sample.domain.entity.City;
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
        melbourne = CityRepositoryFixture.getMelbourne();
    }

    @Test
    public void creates_city_given_name_and_state_country() {
        Long cityId = repository.save(melbourne).getId();

        assertThat(repository.getOne(cityId)).isEqualTo(melbourne);
    }

    @Test
    public void finds_city_given_name_and_country() {
        repository.save(melbourne);

        City result  = repository.findOne(CitySpecFactory.byNameAndCountry(melbourne));

        assertThat(result).isEqualTo(melbourne);
    }

    @Test
    public void finds_all_cities_given_country() {
        City sydney = CityRepositoryFixture.getSydney();
        repository.save(Arrays.asList(melbourne, sydney));

        List<City> results  = repository.findAll(CitySpecFactory.byCountry(CityRepositoryFixture.getAustralianCities()));

        assertThat(results).containsAll(Arrays.asList(melbourne, sydney));
    }
}
