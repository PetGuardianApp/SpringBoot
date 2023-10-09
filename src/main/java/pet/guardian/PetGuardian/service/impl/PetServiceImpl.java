package pet.guardian.PetGuardian.service.impl;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.guardian.PetGuardian.commons.GenericServiceImpl;
import pet.guardian.PetGuardian.model.Pets;
import pet.guardian.PetGuardian.service.api.PetsServiceAPI;

@Service
public class PetServiceImpl extends GenericServiceImpl<Pets,Pets> implements PetsServiceAPI {
    @Autowired
    private Firestore firestore;
    @Override
    public CollectionReference getCollection() {
        return firestore.collection("pets");
    }
}
