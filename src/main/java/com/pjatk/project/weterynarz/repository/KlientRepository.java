package com.pjatk.project.weterynarz.repository;

import com.pjatk.project.weterynarz.model.Klient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlientRepository extends JpaRepository<Klient, Long> {

}
