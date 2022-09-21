package com.arnaud.thymewizard.thymewizardapplication.user.web;

import com.arnaud.thymewizard.thymewizardapplication.user.CreateUserParameters;
import com.arnaud.thymewizard.thymewizardapplication.user.Gender;
import com.arnaud.thymewizard.thymewizardapplication.user.PhoneNumber;
import com.arnaud.thymewizard.thymewizardapplication.user.UserName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

// TODO: Custom Validator
// TODO: Groups Validation and Order

public class CreateUserFormData {
    @NotBlank
    @Size(max=10)
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private Gender gender;
    @NotBlank
    @Email
    private String email;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    @NotBlank
    @Pattern(regexp = "[0-9.\\-() x/+]+")
    private String phoneNumber;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CreateUserParameters toParameters() {
        return new CreateUserParameters(new UserName(firstName, lastName),
                gender,
                birthday,
                new com.arnaud.thymewizard.thymewizardapplication.user.Email(email),
                new PhoneNumber(phoneNumber));
    }
}
