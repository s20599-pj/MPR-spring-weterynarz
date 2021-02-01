package com.pjatk.project.weterynarz.repository;

import com.pjatk.project.weterynarz.model.Uslugi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UslugiRepository extends JpaRepository<Uslugi, Long> {
}
