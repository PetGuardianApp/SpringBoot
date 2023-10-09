package pet.guardian.PetGuardian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;

import pet.guardian.PetGuardian.commons.GenericServiceImpl;
import pet.guardian.PetGuardian.model.Client;
import pet.guardian.PetGuardian.service.api.ClientServiceAPI;

@Service
public class ClientServiceImpl extends GenericServiceImpl<Client, Client> implements ClientServiceAPI {

    @Autowired
    private Firestore firestore;

    @Override
    public CollectionReference getCollection() {
        return firestore.collection("client");
    }
}
