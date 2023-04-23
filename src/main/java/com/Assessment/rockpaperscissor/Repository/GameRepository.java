package com.Assessment.rockpaperscissor.Repository;

import com.Assessment.rockpaperscissor.Entity.Records;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Records,Integer> {}
