package ac.ks.demo.repository;

import ac.ks.demo.domain.Basic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;

public interface BasicRepository extends JpaRepository<Basic, String> {
    List<Basic> findAllByname(final String name);
    Basic findFirstByname(final String name);
}
