package com.glo.app.entity;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddress {

    @Id
    private int addresId;
    @Size(max = 25, message = "The length of the address cannot be more than 25")
    private String address;
    @Pattern(regexp = "^[a-zA-Z ]+$" , message = "The city must not be contain the character other than space")
    private String city;
    @Min(value = 100000, message = "The pincode must be 6 digit long")
    @Max(value = 1000000, message = "The pincode must be 6 digit long")
    private int pinCode;
    private String state;


}
