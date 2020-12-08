package eu.accesa.springboottraining.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InternshipKey implements Serializable {

    private static final long serialVersionUID = 1L;//cauta ce face?//java o foslosste la serializarea chei compuse

    @Column(name="company_id")
    private Long companyId;
    @Column(name="intern_id")
    private Long internId;

    public InternshipKey() {
    }

    public InternshipKey(Long companyId, Long internId) {
        this.companyId = companyId;
        this.internId = internId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getInternId() {
        return internId;
    }

    public void setInternId(Long internId) {
        this.internId = internId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternshipKey that = (InternshipKey) o;
        return Objects.equals(companyId, that.companyId) &&
                Objects.equals(internId, that.internId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, internId);
    }
}
