package pet.guardian.PetGuardian.service.impl;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.guardian.PetGuardian.commons.GenericServiceImpl;
import pet.guardian.PetGuardian.model.Vet;
import pet.guardian.PetGuardian.service.api.VetServiceAPI;
@Service
public class VetServiceImpl extends GenericServiceImpl<Vet,Vet> implements VetServiceAPI {
    @Autowired
    private Firestore firestore;
    @Override
    public CollectionReference getCollection() {
        return firestore.collection("vet");
    }
}
