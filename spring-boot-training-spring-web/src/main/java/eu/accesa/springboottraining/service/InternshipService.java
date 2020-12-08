package eu.accesa.springboottraining.service;


import eu.accesa.springboottraining.dto.InternshipDto;
import eu.accesa.springboottraining.persistence.entity.Company;
import eu.accesa.springboottraining.persistence.entity.Intern;
import eu.accesa.springboottraining.persistence.entity.Internship;
import eu.accesa.springboottraining.persistence.entity.InternshipKey;


import java.util.List;
import java.util.Optional;

public interface InternshipService {

    InternshipDto save(InternshipDto internshipDto);

    List<InternshipDto> findAll();

    List<InternshipDto> findInternshipByIntern_NameContains(String internName);

    List<InternshipDto> findInternshipByCompany_NameContains(String companyName);

    void deleteById(InternshipKey internshipKey);



}
