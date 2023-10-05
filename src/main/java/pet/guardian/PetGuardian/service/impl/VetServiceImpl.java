package pet.guardian.PetGuardian.service.impl;

import com.google.cloud.firestore.CollectionReference;
import pet.guardian.PetGuardian.commons.GenericServiceImpl;
import pet.guardian.PetGuardian.model.Vet;
import pet.guardian.PetGuardian.service.api.VetServiceAPI;

public class VetServiceImpl extends GenericServiceImpl<Vet,Vet> implements VetServiceAPI {
    @Override
    public CollectionReference getCollection() {
        return null;
    }
}
