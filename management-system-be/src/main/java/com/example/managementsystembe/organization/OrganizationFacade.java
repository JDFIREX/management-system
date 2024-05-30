package com.example.managementsystembe.organization;


import com.example.managementsystembe.common.Security.SecurityFacade;
import com.example.managementsystembe.organization.dto.OrganizationDto;
import com.example.managementsystembe.organization.exceptions.OrganizationNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
class OrganizationFacade {
    final OrganizationRepository organizationRepository;
    final OrganizationMapper organizationMapper;
    final SecurityFacade securityFacade;
    public Page<OrganizationDto> findAll(Pageable pageable) {
        log.info("Organization Facade: findAll");
        return organizationRepository.findAll(pageable)
                .map(organizationMapper::toDto);
    }

    public OrganizationDto findOne(String id) {
        log.info("Organization Facade: findOne");
        return organizationMapper.toDto(
            organizationRepository.findById(id).orElseThrow(() -> new OrganizationNotFoundException(id))
        );
    }

    public OrganizationDto create(OrganizationDto organizationDto) {
        var user = securityFacade.getCurrentUserPrincipal();
        log.info("user: {}", user);
        log.info("Organization Facade: create");
        return organizationMapper.toDto(
            organizationRepository.save(organizationMapper.toEntity(organizationDto))
        );
    }
}
