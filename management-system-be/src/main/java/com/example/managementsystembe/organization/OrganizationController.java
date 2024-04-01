package com.example.managementsystembe.organization;

import com.example.managementsystembe.organization.dto.OrganizationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@RequestMapping("/organizations")
@RequiredArgsConstructor
class OrganizationController {

    private final OrganizationFacade organizationFacade;

    @GetMapping
    Page<OrganizationDto> findAll(@PageableDefault Pageable pageable) {
        return organizationFacade.findAll(pageable);
    }

}
