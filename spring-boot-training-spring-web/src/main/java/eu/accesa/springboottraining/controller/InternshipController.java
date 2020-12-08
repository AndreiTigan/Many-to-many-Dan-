package eu.accesa.springboottraining.controller;


import eu.accesa.springboottraining.dto.InternshipDto;
import eu.accesa.springboottraining.persistence.entity.InternshipKey;
import eu.accesa.springboottraining.service.InternshipService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@OpenAPIDefinition
@RequestMapping("/internship")
@Tag(name = "Internships")

public class InternshipController {

    private final InternshipService internshipService;


    public InternshipController(InternshipService internshipService) {
        this.internshipService = internshipService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InternshipDto save(@Valid @RequestBody InternshipDto internshipDto) {
        return internshipService.save(internshipDto);
    }

    @GetMapping
    public List<InternshipDto> findInterns() {
        return internshipService.findAll();
    }

    @GetMapping("/interns/{internName}")
    public List<InternshipDto> findByInternshipByIntern(@PathVariable String internName) {

        return internshipService.findInternshipByIntern_NameContains(internName);
    }
    @GetMapping("/companies/{companyName}")
    public List<InternshipDto> findByInternshipByCompany(@PathVariable String companyName) {

        return internshipService.findInternshipByCompany_NameContains(companyName);
    }
    @PutMapping
    public InternshipDto update(@RequestBody InternshipDto internshipDto) {
        return internshipService.save(internshipDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable InternshipKey internshipKey) {
        internshipService.deleteById(internshipKey);
    }

}

