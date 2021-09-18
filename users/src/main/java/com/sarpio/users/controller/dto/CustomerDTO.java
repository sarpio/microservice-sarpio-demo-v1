package com.sarpio.users.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CustomerDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotEmpty(message = "First name cannot be empty")
    @Size(min = 2, max = 50, message = "user first name should have at least 2 characters and no more then 50")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    @Size(min = 2, max = 50, message = "user last name should have at least 2 characters and no more then 50")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "Email name cannot be empty")
    @Email
    @Column(name = "email", unique = true)
    private String email;
}
