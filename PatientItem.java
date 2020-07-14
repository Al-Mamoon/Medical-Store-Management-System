package sample;

import javafx.scene.control.DatePicker;

import java.time.format.DateTimeFormatter;

public class PatientItem {
    private String niNumber, firstName, surName, billingName, address, postCode, city,  country,
            homePhone, mobilePhone, faxPhone, memo, patientId, patientNhsNumber, emisNumber, gpAppointmentRef;
    private DatePicker dateOfBirth;

    public PatientItem() {
        this.niNumber = "";
        this.firstName = "";
        this.surName = "";
        this.dateOfBirth = null;
        this.billingName = "";
        this.address = "";
        this.postCode = "";
        this.city = "";
        this.country = "";
        this.homePhone = "";
        this.mobilePhone = "";
        this.faxPhone = "";
        this.memo = "";
        this.patientId = "";
        this.patientNhsNumber = "";
        this.emisNumber = "";
        this.gpAppointmentRef = "";
    }

    public PatientItem(String niNumber, String firstName, String surName, DatePicker dateOfBirth, String billingName,
                       String address, String postCode, String city, String country, String homePhone,
                       String mobilePhone, String faxPhone, String memo, String patientId, String patientNhsNumber,
                       String emisNumber, String gpAppointmentRef) {
        this.niNumber = niNumber;
        this.firstName = firstName;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.billingName = billingName;
        this.address = address;
        this.postCode = postCode;
        this.city = city;
        this.country = country;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.faxPhone = faxPhone;
        this.memo = memo;
        this.patientId = patientId;
        this.patientNhsNumber = patientNhsNumber;
        this.emisNumber = emisNumber;
        this.gpAppointmentRef = gpAppointmentRef;
    }

    public String getNiNumber() {
        return niNumber;
    }

    public void setNiNumber(String niNumber) {
        this.niNumber = niNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getDateOfBirth() {
        return dateOfBirth.getValue().format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
    }

    public void setDateOfBirth(DatePicker dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBillingName() {
        return billingName;
    }

    public void setBillingName(String billingName) {
        this.billingName = billingName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getFaxPhone() {
        return faxPhone;
    }

    public void setFaxPhone(String faxPhone) {
        this.faxPhone = faxPhone;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientNhsNumber() {
        return patientNhsNumber;
    }

    public void setPatientNhsNumber(String patientNhsNumber) {
        this.patientNhsNumber = patientNhsNumber;
    }

    public String getEmisNumber() {
        return emisNumber;
    }

    public void setEmisNumber(String emisNumber) {
        this.emisNumber = emisNumber;
    }

    public String getGpAppointmentRef() {
        return gpAppointmentRef;
    }

    public void setGpAppointmentRef(String gpAppointmentRef) {
        this.gpAppointmentRef = gpAppointmentRef;
    }
}
