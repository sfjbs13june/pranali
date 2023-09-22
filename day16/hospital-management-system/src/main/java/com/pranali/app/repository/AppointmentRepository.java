package com.pranali.app.repository;


import com.pranali.app.model.Appoinment;
import com.pranali.app.model.Prescription;
import org.bson.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends MongoRepository<Appoinment, String> {


    public Appoinment findBydoctorName(String doctorName);


    public Appoinment findBypatientName(String patientName);

    public Document save(Appoinment appointment);


}

