package com.middleman.authentication.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.middleman.authentication.models.ERole;
import com.middleman.authentication.models.Role;
 

/**
 * Manages role entities in roles collection in the database
 */
public interface RoleRepository extends MongoRepository<Role, String>{
    Optional<Role> findByRole(ERole role);
}
