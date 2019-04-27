package ac.ks.demo.repository;

import ac.ks.demo.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location,String> {
    List<Location> findAllByaddress(final String address);
    Location findFirstByaddress(final String address);
}
