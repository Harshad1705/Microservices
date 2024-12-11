package harrySpringBoot.organization_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import harrySpringBoot.organization_service.dto.OrganizationDto;
import harrySpringBoot.organization_service.service.impl.OrganizationServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationServiceImpl organizationService;

    @PostMapping()
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {

        OrganizationDto saveOrganizationDto = organizationService.saveOrganizationDto(organizationDto);
        
        return new ResponseEntity<>(saveOrganizationDto, HttpStatus.CREATED);
    }
    
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String code) {

        OrganizationDto organizationDto = organizationService.getOrganizationByCode(code);
        
        return new ResponseEntity<>(organizationDto, HttpStatus.OK);
    }
    

}
