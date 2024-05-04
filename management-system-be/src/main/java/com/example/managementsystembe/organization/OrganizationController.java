package com.example.managementsystembe.organization;

import com.example.managementsystembe.organization.dto.OrganizationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationFacade organizationFacade;

    @GetMapping
    public Page<OrganizationDto> findAll(@PageableDefault Pageable pageable) {
        return organizationFacade.findAll(pageable);
    }

    @GetMapping("/{id}")
    public OrganizationDto findOne(@PathVariable final String id) {
        return organizationFacade.findOne(id);
    }

    @PostMapping
    public OrganizationDto create(OrganizationDto organizationDto) {
        return organizationFacade.create(organizationDto);
    }

}