package com.glo.app.dto;

import jakarta.validation.constraints.Size;

public class SIMValidationDtoString {


    private Long serviceNumber;


    private Long simNumber;
    @Size(min = 10, max = 10, message = "The size of the serviceNumber 10 digit length")
    private String serviceNumberString;

    @Size(min = 12, max = 12, message = "The size of the SimNumber must be 13 digit length")
    private String simNumberString;

    public SIMValidationDtoString(Long serviceNumber, Long simNumber, String serviceNumberString, String simNumberString) {
        this.serviceNumber = serviceNumber;
        this.simNumber = simNumber;
        this.serviceNumberString = serviceNumberString;
        this.simNumberString = simNumberString;
    }

    public SIMValidationDtoString() {
    }

    public Long getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(Long serviceNumber) {
        this.serviceNumber = serviceNumber;
        this.serviceNumberString = this.serviceNumber+"";
    }

    public Long getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(Long simNumber) {
        this.simNumber = simNumber;
        this.simNumberString = this.simNumber+"";
    }

    public String getServiceNumberString() {
        return serviceNumberString;
    }

    public void setServiceNumberString(String serviceNumberString) {
        this.serviceNumberString = serviceNumberString;
    }

    public String getSimNumberString() {
        return simNumberString;
    }

    public void setSimNumberString(String simNumberString) {
        this.simNumberString = simNumberString;
    }

    @Override
    public String toString() {
        return "SIMValidationDtoString{" +
                "serviceNumber=" + serviceNumber +
                ", simNumber=" + simNumber +
                ", serviceNumberString='" + serviceNumberString + '\'' +
                ", simNumberString='" + simNumberString + '\'' +
                '}';
    }
}
