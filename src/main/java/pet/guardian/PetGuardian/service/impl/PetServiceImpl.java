package pet.guardian.PetGuardian.service.impl;

import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.guardian.PetGuardian.commons.GenericServiceImpl;
import pet.guardian.PetGuardian.dto.PetDTO;
import pet.guardian.PetGuardian.model.Pet;
import pet.guardian.PetGuardian.service.api.PetServiceAPI;


@Service
public class PetServiceImpl extends GenericServiceImpl<Pet, PetDTO> implements PetServiceAPI {
    @Autowired
    private Firestore firestore;

    @Override
    public CollectionReference getCollection() {
        return firestore.collection("pet");
    }


}
