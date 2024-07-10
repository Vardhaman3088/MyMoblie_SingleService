package com.glo.app.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerIdentity {

    @Id
    private long uniqueIdNumber;
    private String dateOfBirth;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String state;
}
