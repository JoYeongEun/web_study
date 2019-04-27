package ac.ks.demo.repository;


import ac.ks.demo.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile,String> {

    List<Profile> findAllBynetwork(final String network);
    Profile findFirstBynetwork(final String network);
}
