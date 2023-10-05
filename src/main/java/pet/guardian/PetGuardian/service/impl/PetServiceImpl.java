package pet.guardian.PetGuardian.service.impl;

import com.google.cloud.firestore.CollectionReference;
import org.springframework.stereotype.Service;
import pet.guardian.PetGuardian.commons.GenericServiceImpl;
import pet.guardian.PetGuardian.model.Pets;
import pet.guardian.PetGuardian.service.api.PetsServiceAPI;

@Service
public class PetServiceImpl extends GenericServiceImpl<Pets,Pets> implements PetsServiceAPI {
    @Override
    public CollectionReference getCollection() {
        return null;
    }
}
