package com.example.managementsystembe.organization;


import com.example.managementsystembe.organization.dto.OrganizationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
class OrganizationFacade {

    public Page<OrganizationDto> findAll(Pageable pageable) {
        return null;
    }
}
