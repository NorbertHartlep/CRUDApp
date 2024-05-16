package com.example.demo.repositories;

import com.example.demo.models.entities.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpuRepository extends JpaRepository<Cpu, Integer> {
}
