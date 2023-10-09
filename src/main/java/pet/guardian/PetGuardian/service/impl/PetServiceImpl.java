package pet.guardian.PetGuardian.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.guardian.PetGuardian.commons.GenericServiceImpl;
import pet.guardian.PetGuardian.dto.PetsDTO;
import pet.guardian.PetGuardian.model.Pets;
import pet.guardian.PetGuardian.service.api.PetsServiceAPI;


@Service
public class PetServiceImpl extends GenericServiceImpl<Pets, PetsDTO> implements PetsServiceAPI {
    @Autowired
    private Firestore firestore;

    @Override
    public CollectionReference getCollection() {
        return firestore.collection("/pets");
    }


}
