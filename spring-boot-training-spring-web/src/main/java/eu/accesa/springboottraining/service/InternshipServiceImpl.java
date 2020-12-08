package eu.accesa.springboottraining.service;

import eu.accesa.springboottraining.dto.InternshipDto;
import eu.accesa.springboottraining.persistence.dao.CompanyRepository;
import eu.accesa.springboottraining.persistence.dao.InternRepository;
import eu.accesa.springboottraining.persistence.dao.InternshipRepository;
import eu.accesa.springboottraining.persistence.entity.Intern;
import eu.accesa.springboottraining.persistence.entity.Internship;
import eu.accesa.springboottraining.persistence.entity.InternshipKey;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static eu.accesa.springboottraining.dto.mapper.InternshipMapper.from;

@Service
public class InternshipServiceImpl implements InternshipService {

    private final InternshipRepository internshipRepository;
    private final CompanyRepository companyRepository;
    private final InternRepository internRepository;

    public InternshipServiceImpl(InternshipRepository internshipRepository,
                                 CompanyRepository companyRepository,
                                 InternRepository internRepository) {
        this.internshipRepository = internshipRepository;
        this.companyRepository = companyRepository;
        this.internRepository = internRepository;
    }

    @Override
    public InternshipDto save(InternshipDto internshipDto) {
        Internship internship = internshipRepository.save(from(internshipDto));
        return from(internship);
    }

    @Override
    public List<InternshipDto> findAll() {
        return from(internshipRepository.findAll());
    }

    @Override
    public List<InternshipDto> findInternshipByIntern_NameContains(String internName) {
        Optional<Intern> intern = internRepository.findInternByNameContainingIgnoreCase(internName);

        if (intern.isPresent()) {
            return from(internshipRepository.findInternshipByIntern_NameContainingIgnoreCase(internName));
        }

        //TODO  throw exception
        return null;
    }

    @Override
    public List<InternshipDto> findInternshipByCompany_NameContains(String companyName) {
        List<Internship> internShipList = internshipRepository.findInternshipByCompany_NameContains(companyName);
        return from(internShipList);
    }

    @Override
    public void deleteById(InternshipKey internshipKey) {
        internshipRepository.deleteById(internshipKey);
    }
}

