package pet.guardian.PetGuardian.service.impl;

import com.google.cloud.firestore.CollectionReference;

import pet.guardian.PetGuardian.commons.GenericServiceImpl;
import pet.guardian.PetGuardian.model.Appointments;
import pet.guardian.PetGuardian.service.api.AppointmentsServiceAPI;

public class AppointmentsServiceImpl extends GenericServiceImpl<Appointments, Appointments> implements AppointmentsServiceAPI {

    @Override
    public CollectionReference getCollection() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCollection'");
    }
    
}
