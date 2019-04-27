package ac.ks.demo.repository;

import ac.ks.demo.domain.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface WorkRepository extends JpaRepository<Work,String> {
    List<Work> findAllBycompany (final String company);
    Work findFirstBycompany(final String company);
}
