package com.pranali.app.controller;


import com.pranali.app.model.Appoinment;
import com.pranali.app.model.Prescription;
import com.pranali.app.repository.AppointmentRepository;
import com.pranali.app.repository.PrescriptionRepository;
import org.apache.catalina.Store;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Cond.when;

@RunWith(MockitoJUnitRunner.class)
public class DoctorControllerTest {

    @InjectMocks
    private DoctorController doctorController;

    @Mock
     private AppointmentRepository appointmentRepository;
    @Mock
    private PrescriptionRepository prescriptionRepository;

    @Test
    public void getDoctorAppointmentTest() {
        Prescription prescription = new Prescription("10a","5","Stomach infection","Pranali","Aashish");
        Appoinment appoinment = new Appoinment("5","Pranali","Aashish","25092023",prescription);
        List<Appoinment>appoinments = new ArrayList<>();
        appoinments.add(appoinment);
        when(appointmentRepository.findAll()).thenReturn(appoinments);
        List<Appoinment> result = (List<Appoinment>) doctorController.getAppointments("Aashish");

        for (Appoinment appoinment1: result) {
            assertEquals(appoinment.getAppointmentId(),appoinment1.getAppointmentId());
            assertEquals(appoinment.getPatientName(),appoinment1.getPatientName());
            assertEquals(appoinment.getDoctorName(),appoinment1.getDoctorName());
            assertEquals(appoinment.getDate(),appoinment1.getDate());
            assertEquals(appoinment.getPrescription(),appoinment1.getPrescription());

        }
    }

    @Test
    public void saveDoctorAppoinmentTest() {
        Prescription prescription = new Prescription("10a","5","Stomach infection","Pranali","Aashish");
        Appoinment appoinment = new Appoinment("5","Pranali","Aashish","25092023",prescription);
        when(appointmentRepository.save(appoinment)).thenReturn(appoinment);
        when(prescriptionRepository.save(prescription)).thenReturn(prescription);
        String response = String.valueOf(doctorController.saveAppointment(appoinment));
        assertEquals("Appoinment"+ appoinment.getAppointmentId()+"saved Successfully",response);





    }


}
