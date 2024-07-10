package com.glo.app.dto;

public class CustomeridentityDto {
    private long uniqueIdNumber;
    private String dateOfBirth;
    private String emailAddress;
    private String firstName;
    private String id_type;
    private String lastName;
    private String state;

    public CustomeridentityDto(long uniqueIdNumber, String dateOfBirth, String emailAddress, String firstName, String id_type, String lastName, String state) {
        this.uniqueIdNumber = uniqueIdNumber;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.id_type = id_type;
        this.lastName = lastName;
        this.state = state;
    }

    public CustomeridentityDto() {
    }

    public long getUniqueIdNumber() {
        return uniqueIdNumber;
    }

    public void setUniqueIdNumber(long uniqueIdNumber) {
        this.uniqueIdNumber = uniqueIdNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CustomeridentityDto{" +
                "uniqueIdNumber=" + uniqueIdNumber +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id_type='" + id_type + '\'' +
                ", lastName='" + lastName + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
