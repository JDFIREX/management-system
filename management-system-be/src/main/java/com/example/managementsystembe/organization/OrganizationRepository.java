package com.example.managementsystembe.organization;

import com.example.managementsystembe.organization.dao.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrganizationRepository  extends JpaRepository<Organization, String> {
}
