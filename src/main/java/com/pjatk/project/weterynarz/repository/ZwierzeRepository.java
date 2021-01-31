package com.pjatk.project.weterynarz.repository;

import com.pjatk.project.weterynarz.model.Zwierze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZwierzeRepository extends JpaRepository<Zwierze, Long> {

}
