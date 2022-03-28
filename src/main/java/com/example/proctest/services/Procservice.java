package com.example.proctest.services;

import com.example.proctest.model.Procurement;
import com.example.proctest.repository.ProcurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class Procservice {
    @PersistenceContext
    EntityManager entityManager;

    ProcurementRepository procurementRepository;

    @Autowired
    public Procservice(ProcurementRepository procurementRepository) {
        this.procurementRepository = procurementRepository;
    }

    @Transactional
    public Procurement getById(Long id) {
        Procurement fromdb = procurementRepository.getById(id);
        return fromdb;
    }

    @Transactional
    public List<Procurement> findAll() {

        return procurementRepository.findAll();
    }

    @Transactional
    public Optional<Procurement> findById(Long id){
        return procurementRepository.findById(id);
    }
}
