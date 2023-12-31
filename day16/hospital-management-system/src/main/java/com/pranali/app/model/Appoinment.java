package com.pranali.app.model;


import org.springframework.stereotype.Component;

@Component
public class Appoinment {

    String appointmentId;
    String patientName;
    String doctorName;
    String date;
    Prescription prescription;

    public Appoinment() {
    }

    public Appoinment(String appointmentId, String patientName, String doctorName, String date, Prescription prescription){
      this.appointmentId = appointmentId;
      this.patientName = patientName;
      this.doctorName = doctorName;
      this.date = date;
      this.prescription = prescription;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public void add(Appoinment appointment) {
    }
}
