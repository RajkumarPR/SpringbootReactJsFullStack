package com.hid.ppmtool.services;

import com.hid.ppmtool.domain.Project;
import com.hid.ppmtool.exception.ProjectIdException;
import com.hid.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

/**
 * @author rraigonde
 * @date 07-12-2018 01:04
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        try {

            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return this.projectRepository.save(project);
        } catch (Exception t) {
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists");
        }
    }

    public Project findProjectIdentifier(String identifier) {
        Project project = this.projectRepository.findByProjectIdentifier(identifier);

        if (project == null) {
            throw new ProjectIdException("Poject ID '" + identifier + "' does not exists");
        }
        return project;
    }

    public Iterable<Project> findAllProjects() {

        Iterable<Project> projects = this.projectRepository.findAll();
        long size = StreamSupport.stream(projects.spliterator(), false).count();
        if (size == 0) {
            throw new ProjectIdException("No project exists");
        }
        return projects;
    }

    public void deleteProjectByProjectIdentifier(String projectId) {

        Project project = this.projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if (project == null)
        {
            throw new ProjectIdException("The project with id '"+projectId+"' does not exists");
        }
        projectRepository.deleteById(project.getId());
    }
}
