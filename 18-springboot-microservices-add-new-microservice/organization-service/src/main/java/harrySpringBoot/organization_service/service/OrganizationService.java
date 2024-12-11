package harrySpringBoot.organization_service.service;

import harrySpringBoot.organization_service.dto.OrganizationDto;

public interface OrganizationService {

    OrganizationDto saveOrganizationDto(OrganizationDto organizationDto);

    OrganizationDto getOrganizationByCode(String organizationCode);
    
}