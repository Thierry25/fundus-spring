package com.thierry.fundus.repositories;

import com.thierry.fundus.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Integer> {
}
