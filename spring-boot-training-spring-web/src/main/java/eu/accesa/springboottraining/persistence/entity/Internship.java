package eu.accesa.springboottraining.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="INTERNSHIPS")
@SequenceGenerator(name = "internship_sequence_generator", sequenceName = "INTERNSHIP_SEQUENCE", allocationSize = 1)
public class Internship {
    @EmbeddedId

    InternshipKey id=new InternshipKey();


    @ManyToOne
    @JsonManagedReference
    @MapsId("companyId")
    Company company;


    @ManyToOne
    @JsonManagedReference//daca nu o treci da o eroarea de stackoverflow, el se asteapta la un tip de obiect si primeste mai multe tipuri
    @MapsId("internId")
    Intern intern;

    private LocalDate startDate;
    private LocalDate endDate;

    public InternshipKey getId() {
        return id;
    }

    public void setId(InternshipKey id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
