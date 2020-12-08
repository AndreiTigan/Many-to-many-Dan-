package eu.accesa.springboottraining.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="COMPANIES")

public class Company {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=SEQUENCE, generator="companies_sequence_generator")
    @SequenceGenerator(name = "companies_sequence_generator", sequenceName = "COMPANIES_SEQUENCE", allocationSize = 1)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name="FOUNDED_DATE")
    private LocalDate foundedDate;
    @Column(name="NO_OF_EMPLOYEE")
    private Integer noOfEmployee;

    @JsonBackReference
    @OneToMany(mappedBy ="company")
    private Set<Internship>companiesInterns;

    public Set<Internship> getCompaniesInterns() {
        return companiesInterns;
    }

    public void setCompaniesInterns(Set<Internship> companiesInterns) {
        this.companiesInterns = companiesInterns;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(LocalDate foundedDate) {
        this.foundedDate = foundedDate;
    }

    public Integer getNoOfEmployee() {
        return noOfEmployee;
    }

    public void setNoOfEmployee(Integer noOfEmployee) {
        this.noOfEmployee = noOfEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) &&
                Objects.equals(name, company.name) &&
                Objects.equals(foundedDate, company.foundedDate) &&
                Objects.equals(noOfEmployee, company.noOfEmployee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, foundedDate, noOfEmployee);
    }
}
