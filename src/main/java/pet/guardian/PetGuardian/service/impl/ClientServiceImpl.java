package pet.guardian.PetGuardian.service.impl;

import com.google.cloud.firestore.CollectionReference;
import org.springframework.stereotype.Service;
import pet.guardian.PetGuardian.commons.GenericServiceImpl;
import pet.guardian.PetGuardian.model.Client;
import pet.guardian.PetGuardian.service.api.ClientServiceAPI;
@Service
public class ClientServiceImpl extends GenericServiceImpl<Client,Client> implements ClientServiceAPI {
    @Override
    public CollectionReference getCollection() {
        return null;
    }
}
