package pet.guardian.PetGuardian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.guardian.PetGuardian.dto.PetDTO;
import pet.guardian.PetGuardian.model.Client;
import pet.guardian.PetGuardian.service.api.ClientServiceAPI;
import pet.guardian.PetGuardian.service.api.PetServiceAPI;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/client")
@CrossOrigin("*")
public class ClientRestController {

    @Autowired
    private ClientServiceAPI clientServiceAPI;
    @Autowired
    private PetServiceAPI petServiceAPI;
    @GetMapping(value = "/all")
    public ResponseEntity<Object> getAllClient() throws Exception {
        return new ResponseEntity<>(clientServiceAPI.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Object> getClient(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(clientServiceAPI.get(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create/{id}")
    public ResponseEntity<String> createClient(@RequestBody Client client, @PathVariable String id) throws Exception {
        id = clientServiceAPI.save(client, id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateClient(@PathVariable String id, @RequestBody Client client) throws Exception {
        id = clientServiceAPI.save(client, id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable String id) throws Exception {
        List<PetDTO> pets = petServiceAPI.getAll();
        pets.forEach(pet -> {
            if (Objects.equals(pet.getClient_id(), id)) {
                try {
                    pet.setClient_id("null");
                    petServiceAPI.save(pet,pet.getId());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        clientServiceAPI.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
