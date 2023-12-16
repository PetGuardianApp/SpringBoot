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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pet.guardian.PetGuardian.dto.AppointmentsDTO;
import pet.guardian.PetGuardian.dto.ClientDTO;
import pet.guardian.PetGuardian.dto.PetDTO;
import pet.guardian.PetGuardian.model.Client;
import pet.guardian.PetGuardian.model.Vet;
import pet.guardian.PetGuardian.service.api.AppointmentsServiceAPI;
import pet.guardian.PetGuardian.service.api.ClientServiceAPI;
import pet.guardian.PetGuardian.service.api.PetServiceAPI;
import pet.guardian.PetGuardian.service.api.VetServiceAPI;

@RestController
@RequestMapping(value = "/vet")
@CrossOrigin("*")
public class VetRestController {

    @Autowired
    private VetServiceAPI vetServiceAPI;
    @Autowired
    private PetServiceAPI petServiceAPI;
    @Autowired
    private ClientServiceAPI clientServiceAPI;
    @Autowired
    private AppointmentsServiceAPI appointmentsServiceAPI;

    @GetMapping(value = "/all")
    public ResponseEntity<Object> getAll() throws Exception {
        return new ResponseEntity<>(vetServiceAPI.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Object> findVet(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(vetServiceAPI.get(id), HttpStatus.OK);
    }

    @GetMapping(value = "/findClients/{id}")
    public ResponseEntity<Object> findVetClients(@PathVariable String id) throws Exception {
        List<ClientDTO> clients = new ArrayList<>();
        Set<String> clientIds = new HashSet<>();
        List<PetDTO> pets = petServiceAPI.getAll();
        for (PetDTO pet : pets) {
            if (Objects.equals(pet.getVet_id(), id)) {
                if (pet.getClient_id() != null && clientIds.add(pet.getClient_id())) {
                    clients.add(clientServiceAPI.get(pet.getClient_id()));
                }
            }
        }
        return new ResponseEntity<Object>(clients, HttpStatus.OK);
    }

    @PutMapping(value = "/add/{id}/message")
    public ResponseEntity<Object> addMessage(@PathVariable String id, @RequestBody String message)
            throws Exception {
        Client client = clientServiceAPI.get(id);
        client.setMessage(message);
        return new ResponseEntity<>(clientServiceAPI.save(client, id), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}/message")
    public ResponseEntity<Object> getMessage(@PathVariable String id)
            throws Exception {
        Vet vet = vetServiceAPI.get(id);
        String message = vet.getMessage();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}/message")
    public ResponseEntity<Object> updateMessage(@PathVariable String id) throws Exception {
        Vet vet = vetServiceAPI.get(id);

        // Update the message field to an empty string
        vet.setMessage("");
        return new ResponseEntity<>(vetServiceAPI.save(vet, id), HttpStatus.OK);
    }

    @GetMapping(value = "/findAppointments/{id}")
    public ResponseEntity<Object> getAppointments(@PathVariable String id) throws Exception {
        List<AppointmentsDTO> all_appointments = appointmentsServiceAPI.getAll();
        List<AppointmentsDTO> vet_appointments = new ArrayList<>();
        List<PetDTO> all_vet_pets = getAllPets(id);
        for (PetDTO pet : all_vet_pets) {
            for (AppointmentsDTO appoint : all_appointments) {
                if (Objects.equals(pet.getId(), appoint.getPet_id())) {
                    vet_appointments.add(appoint);
                }

            }
        }
        return new ResponseEntity<Object>(vet_appointments, HttpStatus.OK);
    }

    public List<PetDTO> getAllPets(String id) throws Exception {
        List<PetDTO> client_pets = new ArrayList<>();
        List<PetDTO> all_pets = petServiceAPI.getAll();
        for (PetDTO pet : all_pets) {
            if (Objects.equals(pet.getVet_id(), id)) {
                client_pets.add(pet);
            }
        }
        return client_pets;
    }

    @PostMapping(value = "/create/{id}")
    public ResponseEntity<Object> createVet(@RequestBody Vet vet, @PathVariable String id) throws Exception {
        id = vetServiceAPI.save(vet, id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateVet(@PathVariable String id, @RequestBody Vet vet) throws Exception {
        Vet mew_vet = patchVet(vetServiceAPI.get(id), vet);
        id = vetServiceAPI.save(mew_vet, id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteVet(@PathVariable String id) throws Exception {
        List<PetDTO> pets = petServiceAPI.getAll();
        pets.forEach(pet -> {
            if (Objects.equals(pet.getVet_id(), id)) {
                try {
                    pet.setVet_id("null");
                    petServiceAPI.save(pet, pet.getId());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        vetServiceAPI.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Vet patchVet(Vet vetToUpdate, Vet vet) {
        if (vet.getName() != null) {
            vetToUpdate.setName(vet.getName());
        }
        if (vet.getEmail() != null) {
            vetToUpdate.setEmail(vet.getEmail());
        }
        if (vet.getPhone() != null) {
            vetToUpdate.setPhone(vet.getPhone());
        }
        if (vet.getSurname() != null) {
            vetToUpdate.setSurname(vet.getSurname());
        }
        if (vet.getClinic_address() != null) {
            vetToUpdate.setClinic_address(vet.getClinic_address());
        }
        return vetToUpdate;
    }
}
