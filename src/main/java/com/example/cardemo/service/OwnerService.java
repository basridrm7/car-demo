package com.example.cardemo.service;

import com.example.cardemo.data.entity.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OwnerService {

    Owner saveOwner(Owner owner);

    Owner findById(Long id);

    Page<Owner> findAll(Pageable pageable);

    void deleteOwnerById(Long id);
}