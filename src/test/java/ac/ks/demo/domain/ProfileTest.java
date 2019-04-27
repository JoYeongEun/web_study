package ac.ks.demo.domain;

import ac.ks.demo.repository.ProfileRepository;
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
public class ProfileTest {
    @Autowired
    ProfileRepository profileRepository;
    Profile savedprofile;

    @Before
    public void init(){
        savedprofile = profileRepository.save(Profile.builder()
                .network("Twitter")
                .url("http://www.twitter.com/홍길동")
                .username("홍길동")
                .build()
        );
    }

    @Test
    public void testfindProfile(){
        Profile foundProfile = profileRepository.findById(savedprofile.getUrl()).orElse(null);
        assertThat(foundProfile.getUrl()).isEqualTo(savedprofile.getUrl());
    }

    @Test
    public void testfindAllnetwork(){
        List<Profile> findallnetwork = profileRepository.findAllBynetwork(savedprofile.getNetwork());
        assertThat(findallnetwork.size()).isEqualTo(1);
    }

    @Test
    public void testFirstnetwork(){
        Profile findFirstnetwork = profileRepository.findFirstBynetwork("Twitter");
        assertThat(findFirstnetwork.getNetwork()).isEqualTo("Twitter");
    }

}
