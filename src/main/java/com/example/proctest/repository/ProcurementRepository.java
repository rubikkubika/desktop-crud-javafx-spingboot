package com.example.proctest.repository;

import com.example.proctest.model.Procurement;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.function.Function;

public interface ProcurementRepository extends JpaRepository<Procurement, Long> {
    Procurement getById(Long id);
}