package com.hid.ppmtool.repositories;

import com.hid.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;

/**
 * @author rraigonde
 * @date 07-12-2018 00:55
 */
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    Iterable<Project> findAllById(Iterable<Long> iterable);

    Project findByProjectIdentifier(String identifier);

    @Override
    Iterable<Project> findAll();
}
