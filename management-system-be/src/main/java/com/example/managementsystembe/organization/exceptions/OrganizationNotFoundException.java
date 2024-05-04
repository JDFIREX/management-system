package com.example.managementsystembe.organization.exceptions;

import com.example.managementsystembe.common.exception.AbstractNotFoundException;

public class OrganizationNotFoundException  extends AbstractNotFoundException {

    public OrganizationNotFoundException(String id) {
        super(String.format("Could not find Organization with id: %s.", id));
    }

};
