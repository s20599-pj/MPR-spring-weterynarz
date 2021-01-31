package com.pjatk.project.weterynarz.repository;

import com.pjatk.project.weterynarz.model.Pracownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PracownikRepository extends JpaRepository<Pracownik, Long> {

    @Query("Select p from Pracownik p where p.imie = :imie")
    Optional<Pracownik> getPracownikByImie(String imie);
}
