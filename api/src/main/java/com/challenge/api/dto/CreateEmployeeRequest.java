package com.challenge.api.dto;

/**
 * This class defines the shape of the JSON body required
 * to create a new employee. It acts as a Data Transfer Object (DTO).
 */
public class CreateEmployeeRequest {

    private String firstName;
    private String lastName;
    private String jobTitle;

    // Getters and Setters are required for Spring Boot to map the incoming JSON
    // from the request body to this object.

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}