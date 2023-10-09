package pet.guardian.PetGuardian.controller;

import java.util.List;

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

import pet.guardian.PetGuardian.model.Client;
import pet.guardian.PetGuardian.service.api.ClientServiceAPI;

@RestController
@RequestMapping(value = "/client")
@CrossOrigin("*")
public class ClientRestController {

    @Autowired
    private ClientServiceAPI clientServiceAPI;

    @GetMapping(value = "/all")
    public List<Client> getAllClient() throws Exception {
        return clientServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public Client findClient(@PathVariable String id) throws Exception {
        return clientServiceAPI.get(id);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createClient(@RequestBody Client client) throws Exception {
        String id = clientServiceAPI.save(client);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateClient(@PathVariable String id, @RequestBody Client client) throws Exception {
        id = clientServiceAPI.save(client, id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable String id) throws Exception {
        Client client = clientServiceAPI.get(id);
        if (client != null)
            clientServiceAPI.delete(id);
        else
            return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }
}
