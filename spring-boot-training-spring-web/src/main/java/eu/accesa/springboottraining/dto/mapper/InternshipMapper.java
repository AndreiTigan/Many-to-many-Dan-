package eu.accesa.springboottraining.dto.mapper;

import eu.accesa.springboottraining.dto.InternshipDto;
import eu.accesa.springboottraining.persistence.entity.Internship;


import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static org.springframework.util.CollectionUtils.isEmpty;

public class InternshipMapper {

    public InternshipMapper() {
    }

    public static List<InternshipDto>from(final List<Internship> internships){
        if (isEmpty(internships)) return emptyList();
            return internships.stream().map(InternshipMapper::from).collect(Collectors.toList())      ;
    }
 public static InternshipDto from(final Internship internship){
        if(internship==null)return null;

        final var internshipDto=new InternshipDto();
        internshipDto.setInternshipsKey(internship.getId());
        internshipDto.setIntern(internship.getIntern());
        internshipDto.setCompany(internship.getCompany());
        internshipDto.setStarDate(internship.getStartDate());
        internshipDto.setEndDate(internship.getEndDate());
        return internshipDto;
 }
    public static Internship from(final InternshipDto internshipDto){
        if(internshipDto==null)return null;

        final var internship=new Internship();
        internship.setId(internshipDto.getInternshipsKey());
        internship.setCompany(internshipDto.getCompany());
        internship.setIntern(internshipDto.getIntern());
        internship.setStartDate(internshipDto.getStarDate());
        internship.setEndDate(internshipDto.getEndDate());
         return  internship;
    }
}
