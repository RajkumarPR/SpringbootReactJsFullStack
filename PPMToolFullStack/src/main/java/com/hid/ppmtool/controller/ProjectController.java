package com.hid.ppmtool.controller;

import com.hid.ppmtool.domain.Project;
import com.hid.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/project")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : result.getFieldErrors())
            errorMap.put(error.getField(), error.getDefaultMessage());
            return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(projectService.saveOrUpdateProject(project), HttpStatus.CREATED);
    }
}
