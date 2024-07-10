package com.glo.app.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimDetails {


    @Id
    private int simId;
    private long serviceNumber;
    private long simNumber;
    private String simStatus;

}
