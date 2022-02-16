package com.example.cardemo.data.repository;

import com.example.cardemo.data.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    @Override
    void deleteById(Long id);
}