package pet.guardian.PetGuardian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;

import org.springframework.stereotype.Service;
import pet.guardian.PetGuardian.commons.GenericServiceImpl;
import pet.guardian.PetGuardian.dto.AppointmentsDTO;
import pet.guardian.PetGuardian.model.Appointments;
import pet.guardian.PetGuardian.service.api.AppointmentsServiceAPI;
@Service
public class AppointmentsServiceImpl extends GenericServiceImpl<Appointments, AppointmentsDTO> implements AppointmentsServiceAPI {

    @Autowired
    private Firestore firestore;

    @Override
    public CollectionReference getCollection() {
        return firestore.collection("appointments");
    }
    
}
