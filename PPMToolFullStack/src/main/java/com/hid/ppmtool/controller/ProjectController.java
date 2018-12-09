package com.hid.ppmtool.controller;

import com.hid.ppmtool.domain.Project;
import com.hid.ppmtool.exception.ProjectIdException;
import com.hid.ppmtool.services.MapValidationErrorService;
import com.hid.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rraigonde
 * @date 07-12-2018 01:07
 */

@RestController
@RequestMapping(value = "/api")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("/project")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

        ResponseEntity<?> error = this.mapValidationErrorService.mapValidationError(result);
        if (error != null) {
            return error;
        }
        return new ResponseEntity<>(projectService.saveOrUpdateProject(project), HttpStatus.CREATED);
    }

    @GetMapping(value = "/project/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId){

        Project project = this.projectService.findProjectIdentifier(projectId);

        if (project == null)
        {
             throw new ProjectIdException("Poject ID '"+projectId+"' does not exists");
        }
        return new ResponseEntity<>(project,HttpStatus.OK);
    }
}
