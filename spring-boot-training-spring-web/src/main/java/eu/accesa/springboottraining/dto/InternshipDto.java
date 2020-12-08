package eu.accesa.springboottraining.dto;

import eu.accesa.springboottraining.persistence.entity.Company;
import eu.accesa.springboottraining.persistence.entity.Intern;
import eu.accesa.springboottraining.persistence.entity.InternshipKey;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class InternshipDto {

    // la dto nu mai am ID? fiindca nu e @EmbeddedId ?
    private InternshipKey internshipKey;
    @NotNull
    private Company company;
    private Intern intern;
    @NotNull
    private LocalDate starDate;
    private LocalDate endDate;

    public InternshipKey getInternshipsKey() {
        return internshipKey;
    }

    public void setInternshipsKey(InternshipKey internshipKey) {
        this.internshipKey = internshipKey;
    }

    public Company getCompany() {  return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Intern getIntern() {
        return intern;
    }

    public void setIntern(Intern intern) {
        this.intern = intern;
    }

    public LocalDate getStarDate() {
        return starDate;
    }

    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
