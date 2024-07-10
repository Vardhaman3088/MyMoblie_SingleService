package com.glo.app.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDetailValidationDto {
    @NotNull(message = "firstName cannot be null")
    @Size(max = 15, message = "The FirstName Should be less than 15 character long")
    private String firstName;
    @NotNull(message = "LastName cannot be null")
    @Size(max = 15, message = "The LastName should be less than 15 character long ")
    private String lastname;
    private String confirmEmail;
}
