package pet.guardian.PetGuardian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pet.guardian.PetGuardian.model.Vet;
import pet.guardian.PetGuardian.service.api.VetServiceAPI;

import java.util.List;

@RestController
@RequestMapping(value = "/vet")
@CrossOrigin("*")
public class VetRestController {

    @Autowired
    private VetServiceAPI vetServiceAPI;

    @GetMapping(value = "/all")
    public List<Vet> getAll() throws Exception {
        return vetServiceAPI.getAll();
    }

    @GetMapping(value = "/{id}")
    public Vet findVet(@PathVariable String id) throws Exception {
        return vetServiceAPI.get(id);
    }

    @PostMapping
    public void saveVet(@RequestBody Vet vet) throws Exception {
        vetServiceAPI.save(vet);
    }

    @PutMapping("/{id}")
    public void updatePet(@PathVariable String id, @RequestBody Vet vet) throws Exception {
        vetServiceAPI.save(vet, id);
    }

    @DeleteMapping("/{id}")
    public void deleteVet(@PathVariable String id) throws Exception {
        vetServiceAPI.delete(id);
    }

}
