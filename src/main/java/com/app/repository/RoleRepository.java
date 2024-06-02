package com.app.repository;

import com.app.persistence.entity.RolesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<RolesEntity, Long> {

    List<RolesEntity> findRolesEntitiesByRoleEnumIn(List<String> roleNames);
}
