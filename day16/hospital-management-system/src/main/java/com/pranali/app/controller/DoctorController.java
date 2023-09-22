package com.pranali.app.controller;

import com.pranali.app.model.Appoinment;
//import com.pranali.app.repository.AppoinmentRepository;
import com.pranali.app.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    AppointmentRepository appoinmentRepository;

    @PostMapping("/save")
    public <Appointment> Appointment saveAppointment(@RequestBody Appointment appointment){
      return (Appointment) appoinmentRepository.save((Appoinment) appointment);
    }

    @GetMapping("/doctorappointment")

    public <Appointment> List<Appointment> getAppointments(@RequestParam String doctorName){
    Appoinment appoinment= (Appoinment) appoinmentRepository.findBydoctorName(doctorName);
           return (List<Appointment>) appoinment;
    }

}
