package com.glo.app.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SIMValidationDto {
    @Digits(integer = 10, fraction = 0, message = "The service number must have at most 10 digits")
    private long serviceNumber;
    @Digits(integer = 13, fraction = 0, message = "The service number must have at most 13 digits")
    private long simNumber;

}
