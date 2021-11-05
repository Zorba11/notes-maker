package com.zorba11.notemaker.repositories;

import com.zorba11.notemaker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
