package com.example.managementsystembe.organization.dao;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "organization")
class Organization {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id", nullable = false)
    private String id = UUID.randomUUID().toString();

    @Column(name = "name", nullable = false)
    private String name;

}
