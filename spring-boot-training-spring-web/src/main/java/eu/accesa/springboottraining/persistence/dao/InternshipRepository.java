package eu.accesa.springboottraining.persistence.dao;


import eu.accesa.springboottraining.persistence.entity.Internship;
import eu.accesa.springboottraining.persistence.entity.InternshipKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface InternshipRepository extends JpaRepository<Internship, InternshipKey> {

    List<Internship> findInternshipByIntern_NameContainingIgnoreCase(String internName);


    List<Internship> findInternshipByCompany_NameContains(String companyName);
}
