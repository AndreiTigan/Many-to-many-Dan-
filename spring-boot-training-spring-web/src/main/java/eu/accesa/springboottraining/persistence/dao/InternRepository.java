package eu.accesa.springboottraining.persistence.dao;

import eu.accesa.springboottraining.persistence.entity.Intern;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InternRepository extends JpaRepository<Intern, Long> {

    Optional<Intern> findInternByNameContainingIgnoreCase(String name);

}
