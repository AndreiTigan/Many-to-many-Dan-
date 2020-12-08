package eu.accesa.springboottraining.dto.mapper;

import eu.accesa.springboottraining.dto.CompanyDto;
import eu.accesa.springboottraining.persistence.entity.Company;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class CompanyMapper {

    private CompanyMapper() {
    }

    public static List<CompanyDto> from(final List<Company> companies) {
        if (CollectionUtils.isEmpty(companies))
            return emptyList();
        return companies
                .stream()
                .map(CompanyMapper::from)
                .collect(Collectors.toList());
    }

    public static CompanyDto from(final Company company) {
        if (company == null)
            return null;

        final var companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setFoundedDate(company.getFoundedDate());
        companyDto.setNoOfEmployee(company.getNoOfEmployee());

        return companyDto;
    }

    public static Company from(final CompanyDto companyDto) {

        if (companyDto == null)
            return null;

        final var company = new Company();
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setFoundedDate(companyDto.getFoundedDate());
        company.setNoOfEmployee(companyDto.getNoOfEmployee());

        return company;
    }


}
