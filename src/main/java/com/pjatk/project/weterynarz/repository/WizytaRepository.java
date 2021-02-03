package com.pjatk.project.weterynarz.repository;

import com.pjatk.project.weterynarz.model.Wizyta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface WizytaRepository extends JpaRepository<Wizyta, Long> {

}
