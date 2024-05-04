package com.example.managementsystembe.organization;

import com.example.managementsystembe.organization.dao.Organization;
import com.example.managementsystembe.organization.dto.OrganizationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface OrganizationMapper {
    OrganizationDto toDto(Organization application);
    Organization toEntity(OrganizationDto applicationDto);
}
