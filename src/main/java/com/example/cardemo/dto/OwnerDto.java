package com.example.cardemo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class OwnerDto {

    @NotEmpty(message = "First name cannot be empty!")
    @Size(min = 2, max = 20, message = "First name must be between 2 and 20 symbols!")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty!")
    @Size(min = 2, max = 20, message = "Last name must be between 2 and 20 symbols!")
    private String lastName;

    @Past
    @NotNull(message = "Date of birth cannot be empty!")
    private LocalDate birthDate;

    public OwnerDto() {
    }

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}