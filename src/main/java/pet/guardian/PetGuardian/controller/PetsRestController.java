package pet.guardian.PetGuardian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pet.guardian.PetGuardian.model.Pets;
import pet.guardian.PetGuardian.service.api.PetsServiceAPI;

import java.util.List;

@RestController
@RequestMapping(value = "/pets")
@CrossOrigin("*")
public class PetsRestController {
    @Autowired
    private PetsServiceAPI petsServiceAPI;

    @GetMapping(value = "/all")
    public List<Pets> getAllPets() throws Exception{
        return petsServiceAPI.getAll();
    }

    @GetMapping(value = "/{id}")
    public Pets findPet(@PathVariable String id) throws Exception{
        return petsServiceAPI.get(id);
    }

    @PostMapping
    public void createPet(@RequestBody Pets pet) throws Exception{
        petsServiceAPI.save(pet);
    }

    @PutMapping("/{id}")
    public void updatePet(@PathVariable String id, @RequestBody Pets pet) throws Exception {
        petsServiceAPI.save(pet, id);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable String id) throws Exception {
        petsServiceAPI.delete(id);
    }


}
