package harrySpringBoot.organization_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import harrySpringBoot.organization_service.dto.OrganizationDto;
import harrySpringBoot.organization_service.entity.Organization;
import harrySpringBoot.organization_service.mapper.OrganizationMapper;
import harrySpringBoot.organization_service.repository.OrganizationRepository;
import harrySpringBoot.organization_service.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;


    @Override
    public OrganizationDto saveOrganizationDto(OrganizationDto organizationDto) {

        Organization organization = OrganizationMapper.mapOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        OrganizationDto savedOrganizationDto = OrganizationMapper.mapOrganizationDto(savedOrganization);

        return savedOrganizationDto;
    }


    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {

        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);

        return OrganizationMapper.mapOrganizationDto(organization);

    }
    
}
