package eu.accesa.springboottraining.service;

import eu.accesa.springboottraining.dto.CompanyDto;
import eu.accesa.springboottraining.dto.mapper.CompanyMapper;
import eu.accesa.springboottraining.persistence.dao.CompanyRepository;
import eu.accesa.springboottraining.persistence.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static eu.accesa.springboottraining.dto.mapper.CompanyMapper.from;
//importul static permite accesul la metodele din mapper

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public CompanyDto save(CompanyDto companyDto) {
        Company company = companyRepository.save(from(companyDto));
        return from(company);
    }

    @Override
    public List<CompanyDto> findall() {
        return from(companyRepository.findAll());
    }

    @Override
    public Optional<CompanyDto> findById(Long id) {
        Optional<Company> byId = companyRepository.findById(id);
        return byId.map(CompanyMapper::from);

    }

    @Override
    public Optional<CompanyDto> findByName(String name) {
        Optional<Company> byName = companyRepository.findByName(name);
        return byName.map(CompanyMapper::from);

    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);

    }
}
