package com.hid.ppmtool.exception;

/**
 * @author rraigonde
 * @date 08-12-2018 13:00
 */
public class ProjectIdExceptionResponse {

    private String  projectIdentifier;

    public ProjectIdExceptionResponse(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
