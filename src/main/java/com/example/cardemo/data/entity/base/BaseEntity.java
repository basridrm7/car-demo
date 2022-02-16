package com.example.cardemo.data.entity.base;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @PrePersist
    public void setCreatedOn() {
        this.createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpdatedOn() {
        this.updatedOn = LocalDateTime.now();
    }

    protected BaseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}