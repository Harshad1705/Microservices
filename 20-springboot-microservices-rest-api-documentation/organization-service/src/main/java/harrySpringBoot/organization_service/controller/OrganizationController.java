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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(
    name = "Organization Service - OrganizationController",
    description = "Organization Controller Exposes REST APIs for Organization-Service" 
)
@RestController
@RequestMapping("api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationServiceImpl organizationService;


    @Operation(
        summary = "Save Organization REST API",
        description = "Save Organization REST API is used to save organization object in database"
        
    )
    @ApiResponse(
        responseCode = "201",
        description = "HTTP Status 201 CREATED"
    )
    @PostMapping()
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {

        OrganizationDto saveOrganizationDto = organizationService.saveOrganizationDto(organizationDto);

        return new ResponseEntity<>(saveOrganizationDto, HttpStatus.CREATED);
    }
    
    
    @Operation(
        summary = "Get Organization REST API",
        description = "Get Organization REST API is used to get organization object from database"
        
    )
    @ApiResponse(
        responseCode = "200",
        description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String code) {

        OrganizationDto organizationDto = organizationService.getOrganizationByCode(code);
        
        return new ResponseEntity<>(organizationDto, HttpStatus.OK);
    }
    

}
