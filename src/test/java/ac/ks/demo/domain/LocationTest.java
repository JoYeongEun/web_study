package ac.ks.demo.domain;

import ac.ks.demo.repository.LocationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LocationTest {
    @Autowired
    LocationRepository locationRepository;
    Location savedLocation;

    @Before
    public void init(){
        savedLocation = locationRepository.save(Location.builder()
                        .address("부산광역시 00구 00번길 000")
                        .postCode("12345")
                        .build()
        );
    }

    @Test
    public void testfindLocation(){
        Location foundLocation = locationRepository.findById(savedLocation.getPostCode()).orElse(null);
        assertThat(foundLocation.getPostCode()).isEqualTo(savedLocation.getPostCode());
    }

    @Test
    public void testfindAlladdress(){
        List<Location>findalladdress = locationRepository.findAllByaddress("부산광역시 00구 00번길 000");
        assertThat(findalladdress.size()).isEqualTo(1);
    }

    @Test
    public void testFirstaddress(){
        Location findfirstaddress = locationRepository.findFirstByaddress("부산광역시 00구 00번길 000");
        assertThat(findfirstaddress.getAddress()).isEqualTo("부산광역시 00구 00번길 000");
    }

    }

