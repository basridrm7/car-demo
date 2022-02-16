package com.example.cardemo.service.implementations;

import com.example.cardemo.data.entity.Owner;
import com.example.cardemo.data.repository.OwnerRepository;
import com.example.cardemo.exception.NotFoundException;
import com.example.cardemo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cannot find owner with id: " + id));
    }

    @Override
    public Page<Owner> findAll(Pageable pageable) {
        return ownerRepository.findAll(pageable);
    }

    @Override
    public void deleteOwnerById(Long id) {
        ownerRepository.deleteById(id);
    }
}