package com.glo.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicDetailValidationDto {

    @NotNull(message = "email address is mandatory field")
    @Email
    @Pattern(regexp = "^[^\\s@]+@[^\\s@]+\\.[a-zA-Z]{2,3}$",message = "Invalid Email")
    private String emailAddress;

    @NotNull(message = "Date Of Birth is mandatory field")
    private String dateOfBirth;

}
