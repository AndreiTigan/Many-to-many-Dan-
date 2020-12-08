package eu.accesa.springboottraining.controller;

import eu.accesa.springboottraining.dto.CompanyDto;
import eu.accesa.springboottraining.service.CompanyService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
@OpenAPIDefinition
@Tag(name="Companies")
public class CompanyController {

    private final CompanyService companyService;


    public CompanyController(CompanyService companyService){this.companyService=companyService;}

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Company Created", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))})
    public CompanyDto save(@RequestBody CompanyDto companyDto){return companyService.save(companyDto);}

    @GetMapping
    @Operation(description = "Get All Companies")
    public List<CompanyDto>findCompanies(){return companyService.findall();}

    @GetMapping("/{id}")
        public CompanyDto findById(@PathVariable Long id){
            Optional<CompanyDto>companyDto=companyService.findById(id);
            return companyDto.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

    @GetMapping("/by")
    public CompanyDto findByName(@RequestParam(value="name")String name){
        Optional<CompanyDto>companyDto=companyService.findByName(name);
        return companyDto.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND))
    ;}
    @PutMapping
    public CompanyDto update(@RequestBody CompanyDto companyDto){return companyService.save(companyDto);}

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){companyService.deleteById(id);}
}
