package com.discord.aurelia.repository;

import com.discord.aurelia.model.Auditlog;

import org.springframework.data.repository.CrudRepository;

public interface AuditlogRepository extends CrudRepository<Auditlog,Long> {
    
}
