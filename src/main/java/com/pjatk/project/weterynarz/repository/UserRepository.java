package com.pjatk.project.weterynarz.repository;

import com.pjatk.project.weterynarz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
