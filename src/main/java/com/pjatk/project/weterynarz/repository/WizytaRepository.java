package com.pjatk.project.weterynarz.repository;

import com.pjatk.project.weterynarz.model.Wizyta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WizytaRepository extends JpaRepository<Wizyta, Long> {
}
