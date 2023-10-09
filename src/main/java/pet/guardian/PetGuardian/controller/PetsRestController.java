package pet.guardian.PetGuardian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.guardian.PetGuardian.model.Pets;
import pet.guardian.PetGuardian.service.api.PetsServiceAPI;

@RestController
@RequestMapping(value = "/pets")
@CrossOrigin("*")
public class PetsRestController {
    @Autowired
    private PetsServiceAPI petsServiceAPI;

    @GetMapping(value = "/all")
    public ResponseEntity<Object> getAllPets() throws Exception {
        return new ResponseEntity<>(petsServiceAPI.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Object> findPet(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(petsServiceAPI.get(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> createPet(@RequestBody Pets pet) throws Exception {
        String id = petsServiceAPI.save(pet);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updatePet(@PathVariable String id, @RequestBody Pets pet) throws Exception {
        return new ResponseEntity<>(petsServiceAPI.save(pet, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVet(@PathVariable String id) throws Exception {
        Pets pet = petsServiceAPI.get(id);
        if (pet != null)
            petsServiceAPI.delete(id);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }


}
