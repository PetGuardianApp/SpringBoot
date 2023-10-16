package pet.guardian.PetGuardian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.guardian.PetGuardian.model.Pet;
import pet.guardian.PetGuardian.service.api.PetServiceAPI;

@RestController
@RequestMapping(value = "/pet")
@CrossOrigin("*")
public class PetRestController {
    @Autowired
    private PetServiceAPI petServiceAPI;

    @GetMapping(value = "/all")
    public ResponseEntity<Object> getAllPets() throws Exception {
        return new ResponseEntity<>(petServiceAPI.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Object> findPet(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(petServiceAPI.get(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> createPet(@RequestBody Pet pet) throws Exception {
        String id = petServiceAPI.save(pet);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Object> updatePet(@PathVariable String id, @RequestBody Pet pet) throws Exception {
        return new ResponseEntity<>(petServiceAPI.save(pet, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteVet(@PathVariable String id) throws Exception {
        Pet pet = petServiceAPI.get(id);
        if (pet != null)
            petServiceAPI.delete(id);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    private Pet patchPet(Pet petToUpdate, Pet pet) {
        if (pet.getName() != null) {
            petToUpdate.setName(pet.getName());
        }
        if (pet.getBirth() != null) {
            petToUpdate.setBirth(pet.getBirth());
        }
        if (pet.getBreed() != null) {
            petToUpdate.setBreed(pet.getBreed());
        }
        if (pet.getWeight() != null) {
            petToUpdate.setWeight(pet.getWeight());
        }
        if (pet.getHealth_info() != null) {
            petToUpdate.setHealth_info(pet.getHealth_info());
        }
        if (pet.getHeight() != null) {
            petToUpdate.setHeight(pet.getHeight());
        }
        return petToUpdate;
    }
}
