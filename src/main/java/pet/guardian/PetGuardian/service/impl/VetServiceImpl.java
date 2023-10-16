package pet.guardian.PetGuardian.service.impl;

import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pet.guardian.PetGuardian.commons.GenericServiceImpl;
import pet.guardian.PetGuardian.dto.VetDTO;
import pet.guardian.PetGuardian.model.Vet;
import pet.guardian.PetGuardian.service.api.VetServiceAPI;

import java.util.concurrent.ExecutionException;

@Service
public class VetServiceImpl extends GenericServiceImpl<Vet, VetDTO> implements VetServiceAPI {
    @Autowired
    private Firestore firestore;

    @Override
    public CollectionReference getCollection() {
        return firestore.collection("vet");
    }

}
