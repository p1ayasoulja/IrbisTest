package com.example.irbis.repo;

import com.example.irbis.Entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SourceRepo extends JpaRepository<Source, Long> {
}
