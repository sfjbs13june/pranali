package com.pranali.app.controller;


import com.pranali.app.model.Appoinment;
import com.pranali.app.model.Prescription;
import com.pranali.app.repository.AppointmentRepository;
import com.pranali.app.repository.PrescriptionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest<List> {

    @InjectMocks
    private PatientController patientController;

    @Mock
    AppointmentRepository appointmentRepository;
    @Mock
    PrescriptionRepository prescriptionRepository;

    @Test

    public void getPatientAppointmentTest() {

        Prescription prescription = new Prescription("10a","5","Stomach infection","Pranali","Aashish");

        Appoinment appointment = new Appoinment("5",Pranali","Aashish","25092023",prescription);

                List<Appoinment> appointmentRepository = new ArrayList<>();

        appointment.add(appointment);

        when(appointmentRepository.findAll()).thenReturn(appointment);

        List<Appoinment> result = (List<Appoinment>) patientController.getMyAppointments("Pranali");

        for (Appoinment appoinment1:

                result) {

            assertEquals(appointment.getAppointmentId(),appoinment1.getAppointmentId());

            assertEquals(appointment.getPatientName(),appoinment1.getPatientName());

            assertEquals(appointment.getDoctorName(),appoinment1.getDoctorName());

            assertEquals(appointment.getDate(),appoinment1.getDate());

            assertEquals(appointment.getPrescription(),appoinment1.getPrescription());

        }

    }

    private void assertEquals(Prescription prescription, Prescription prescription1) {
    }

    private void assertEquals(String appointmentId, String appointmentId1) {
    }


}
