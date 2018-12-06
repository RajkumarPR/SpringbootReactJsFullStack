package com.hid.ppmtool.services;

import com.hid.ppmtool.domain.Project;
import com.hid.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author rraigonde
 * @date 07-12-2018 01:04
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){

        // Logic

        return this.projectRepository.save(project);
    }
}