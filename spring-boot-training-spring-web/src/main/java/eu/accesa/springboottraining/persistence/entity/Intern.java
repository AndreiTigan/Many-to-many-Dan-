package eu.accesa.springboottraining.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "INTERNS")
public class Intern {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=SEQUENCE, generator="interns_sequence_generator")
    @SequenceGenerator(name = "interns_sequence_generator", sequenceName = "INTERNS_SEQUENCE", allocationSize = 1)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "DATE_OF_BIRTH")
    private LocalDate birthDate;

    @JsonBackReference
    @OneToMany(mappedBy = "company")
    private Set <Internship>companiesInterns;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intern intern = (Intern) o;
        return Objects.equals(id, intern.id) &&
                Objects.equals(name, intern.name) &&
                Objects.equals(email, intern.email) &&
                Objects.equals(birthDate, intern.birthDate);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, birthDate);
    }
}
