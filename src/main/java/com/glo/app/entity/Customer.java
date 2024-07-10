package com.glo.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private long uniqueIdNumber;
    private String dateOfBirth;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String idType;
    @OneToOne
    private CustomerAddress customerAddress;
    @OneToOne
    private SimDetails simDetails;
    private String state;

}
