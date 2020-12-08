package eu.accesa.springboottraining.service;

import eu.accesa.springboottraining.dto.CompanyDto;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    CompanyDto save(CompanyDto companyDto);

    List<CompanyDto> findall();

    Optional<CompanyDto> findById(Long id);

    Optional<CompanyDto> findByName(String name);

    void deleteById(Long id);
}
