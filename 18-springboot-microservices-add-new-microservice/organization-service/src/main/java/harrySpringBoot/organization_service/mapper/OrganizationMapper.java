package harrySpringBoot.organization_service.mapper;

import harrySpringBoot.organization_service.dto.OrganizationDto;
import harrySpringBoot.organization_service.entity.Organization;

public class OrganizationMapper {

    public static OrganizationDto mapOrganizationDto(Organization organization) {
        OrganizationDto organizationDto = new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCreatedDate());

        return organizationDto;
    }
    
    public static Organization mapOrganization(OrganizationDto organizationDto) {
        Organization organization = new Organization(
                organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationCode(),
                organizationDto.getCreatedDate()
        );

        return organization;
    }

}
