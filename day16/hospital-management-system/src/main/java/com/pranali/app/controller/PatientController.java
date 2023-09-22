package com.pranali.app.controller;


import com.pranali.app.model.Appoinment;
//import com.pranali.app.repository.AppoinmentRepository;
import com.pranali.app.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController<Appointment> {

    @Autowired
    AppointmentRepository appoinmentRepository;

    @PostMapping("/save")
    public Appointment saveAppointment(@RequestBody Appointment appointment){
      return (Appointment) appoinmentRepository.save((Appoinment) appointment);
    }

    @GetMapping("/myappointment")
    public List<Appointment> getMyAppointments(@RequestParam String patientName){
       Appointment appointment= (Appointment) appoinmentRepository.findBypatientName(patientName);
       return (List<Appointment>) appointment;
    }




}
