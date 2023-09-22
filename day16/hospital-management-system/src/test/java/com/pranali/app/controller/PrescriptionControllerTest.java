package com.pranali.app.controller;


import com.pranali.app.model.Prescription;
import com.pranali.app.repository.AppointmentRepository;
import com.pranali.app.repository.PrescriptionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.validation.constraints.Max;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PrescriptionControllerTest {

    @InjectMocks
    private PrescriptionController prescriptionController;

    @Mock
    AppointmentRepository appointmentRepository;
    @Mock
    PrescriptionRepository prescriptionRepository;


    @Test

    public void viewPrescriptionTest() {

        Prescription prescription = new Prescription("10a","5","Stomach infection","Pranali","Aashish");

        List<Prescription> list= new ArrayList<>();

        list.add(prescription);

        when(prescriptionRepository.findAll()).thenReturn(list);

        List<Prescription> response = (List<Prescription>) prescriptionController.getAllPrescriptions("Pranali");

        for (Prescription prescription1:

                response) {

            assertEquals(prescription.getPrescriptionId(),prescription1.getPrescriptionId());

            assertEquals(prescription.getAppointmentId(),prescription1.getAppointmentId());

            assertEquals(prescription.getPatientName(),prescription1.getPatientName());

            assertEquals(prescription.getDoctorName(),prescription1.getDoctorName());

            assertEquals(prescription.getDescription(),prescription1.getDescription());

        }



    }



    @Test

    public void savePrescription() {

        Prescription prescription = new Prescription("10a","5","Stomach infection","Pranali","Aashish");

        when(prescriptionRepository.save(prescription)).thenReturn(prescription);

        String response = prescriptionController.store(prescription);

        assertEquals("Prescription Saved successsfully",response);

    }


}




