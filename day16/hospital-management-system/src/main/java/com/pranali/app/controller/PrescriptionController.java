package com.pranali.app.controller;


import com.pranali.app.model.Prescription;
import com.pranali.app.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    PrescriptionRepository prescriptionRepository;

    @PostMapping("/saveprescription")
    public Prescription savePrescription(@RequestBody Prescription prescription){
        return prescriptionRepository.save(prescription);
    }

    @GetMapping("/viewprescription")
    public List<Prescription> getAllPrescriptions(String patientName){
        Prescription prescription= prescriptionRepository.findBypatientName(patientName);
        return (List<Prescription>) prescription;

    }


    public String store(Prescription prescription) {
        return null;
    }
}
