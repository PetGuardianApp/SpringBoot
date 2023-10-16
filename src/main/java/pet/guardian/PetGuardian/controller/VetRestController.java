package pet.guardian.PetGuardian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.guardian.PetGuardian.dto.PetDTO;
import pet.guardian.PetGuardian.model.Vet;
import pet.guardian.PetGuardian.service.api.PetServiceAPI;
import pet.guardian.PetGuardian.service.api.VetServiceAPI;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/vet")
@CrossOrigin("*")
public class VetRestController {

    @Autowired
    private VetServiceAPI vetServiceAPI;
    @Autowired
    private PetServiceAPI petServiceAPI;

    @GetMapping(value = "/all")
    public ResponseEntity<Object> getAll() throws Exception {
        return new ResponseEntity<>(vetServiceAPI.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Object> findVet(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(vetServiceAPI.get(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create/{id}")
    public ResponseEntity<Object> createVet(@RequestBody Vet vet, @PathVariable String id) throws Exception {
        id = vetServiceAPI.save(vet, id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateVet(@PathVariable String id, @RequestBody Vet vet) throws Exception {
        id = vetServiceAPI.save(vet, id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteVet(@PathVariable String id) throws Exception {
        List<PetDTO> pets = petServiceAPI.getAll();
        pets.forEach(pet -> {
            if (Objects.equals(pet.getVet_id(), id)) {
                try {
                    pet.setVet_id("null");
                    petServiceAPI.save(pet,pet.getId());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        vetServiceAPI.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
