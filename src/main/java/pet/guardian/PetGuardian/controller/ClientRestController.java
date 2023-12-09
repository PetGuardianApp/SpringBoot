package pet.guardian.PetGuardian.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pet.guardian.PetGuardian.dto.AppointmentsDTO;
import pet.guardian.PetGuardian.dto.PetDTO;
import pet.guardian.PetGuardian.dto.VetDTO;
import pet.guardian.PetGuardian.model.Client;
import pet.guardian.PetGuardian.service.api.AppointmentsServiceAPI;
import pet.guardian.PetGuardian.service.api.ClientServiceAPI;
import pet.guardian.PetGuardian.service.api.PetServiceAPI;
import pet.guardian.PetGuardian.service.api.VetServiceAPI;

@RestController
@RequestMapping(value = "/client")
@CrossOrigin("*")
public class ClientRestController {

    @Autowired
    private VetServiceAPI vetServiceAPI;
    @Autowired
    private PetServiceAPI petServiceAPI;
    @Autowired
    private ClientServiceAPI clientServiceAPI;
    @Autowired
    private AppointmentsServiceAPI appointmentsServiceAPI;

    @GetMapping(value = "/all")
    public ResponseEntity<Object> getAllClient() throws Exception {
        return new ResponseEntity<>(clientServiceAPI.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Object> getClient(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(clientServiceAPI.get(id), HttpStatus.OK);
    }

    @GetMapping(value = "/findPets/{id}")
    public ResponseEntity<Object> getPets(@PathVariable String id) throws Exception {
        List<PetDTO> client_pets = new ArrayList<>();
        List<PetDTO> all_pets = petServiceAPI.getAll();
        for (PetDTO pet : all_pets) {
            if (Objects.equals(pet.getClient_id(), id)) {
                client_pets.add(pet);
            }
        }
        return new ResponseEntity<>(client_pets, HttpStatus.OK);
    }

    @GetMapping(value = "/findAppointments/{id}")
    public ResponseEntity<Object> getAppointments(@PathVariable String id) throws Exception {
        List<AppointmentsDTO> all_appointments = appointmentsServiceAPI.getAll();
        List<AppointmentsDTO> client_appointments = new ArrayList<>();
        List<PetDTO> all_client_pets = getAllPets(id);
        for (PetDTO pet : all_client_pets) {
            for (AppointmentsDTO appoint : all_appointments) {
                if (Objects.equals(pet.getId(), appoint.getPet_id())) {
                    client_appointments.add(appoint);
                }

            }
        }
        return new ResponseEntity<Object>(client_appointments, HttpStatus.OK);
    }

    public List<PetDTO> getAllPets(String id) throws Exception {
        List<PetDTO> client_pets = new ArrayList<>();
        List<PetDTO> all_pets = petServiceAPI.getAll();
        for (PetDTO pet : all_pets) {
            if (Objects.equals(pet.getClient_id(), id)) {
                client_pets.add(pet);
            }
        }
        return client_pets;
    }

    @GetMapping(value = "/findVets/{id}")
    public ResponseEntity<Object> findClientVets(@PathVariable String id) throws Exception {
        List<VetDTO> vets = new ArrayList<>();
        Set<String> vetIds = new HashSet<>();
        List<PetDTO> pets = petServiceAPI.getAll();
        for (PetDTO pet : pets) {
            if (Objects.equals(pet.getClient_id(), id)) {
                if (pet.getVet_id() != null && pet.getVet_id() != "" && vetIds.add(pet.getVet_id())) {
                    vets.add(vetServiceAPI.get(pet.getVet_id()));
                }
            }
        }
        return new ResponseEntity<Object>(vets, HttpStatus.OK);
    }

    @PostMapping(value = "/create/{id}")
    public ResponseEntity<String> createClient(@RequestBody Client client, @PathVariable String id) throws Exception {
        id = clientServiceAPI.save(client, id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateClient(@PathVariable String id, @RequestBody Client client) throws Exception {
        Client new_client = patchClient(clientServiceAPI.get(id), client);
        return new ResponseEntity<>(clientServiceAPI.save(new_client, id), HttpStatus.OK);
    }

    @PutMapping(value = "/add/{id}/notification")
    public ResponseEntity<Object> addNotification(@PathVariable String id, @RequestBody String notification)
            throws Exception {
        Client client = clientServiceAPI.get(id);
        client.addNotification(notification);
        return new ResponseEntity<>(clientServiceAPI.save(client, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable String id) throws Exception {
        List<PetDTO> pets = petServiceAPI.getAll();
        pets.forEach(pet -> {
            if (Objects.equals(pet.getClient_id(), id)) {
                try {
                    pet.setClient_id("null");
                    petServiceAPI.save(pet, pet.getId());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        clientServiceAPI.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Client patchClient(Client clientToUpdate, Client client) {
        if (client.getName() != null) {
            clientToUpdate.setName(client.getName());
        }
        if (client.getPhone() != null) {
            clientToUpdate.setPhone(client.getPhone());
        }
        if (client.getEmail() != null)
            clientToUpdate.setEmail(client.getEmail());
        if (client.getSurnames() != null)
            clientToUpdate.setSurnames(client.getSurnames());
        if (client.getAddress() != null)
            clientToUpdate.setAddress(client.getAddress());
        if (client.getProfile_image() != null)
            clientToUpdate.setProfile_image(client.getProfile_image());
        return clientToUpdate;
    }
}
