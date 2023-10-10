package pet.guardian.PetGuardian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.guardian.PetGuardian.model.Vet;
import pet.guardian.PetGuardian.service.api.VetServiceAPI;

@RestController
@RequestMapping(value = "/vet")
@CrossOrigin("*")
public class VetRestController {

    @Autowired
    private VetServiceAPI vetServiceAPI;

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
    public ResponseEntity<Object> updatePet(@PathVariable String id, @RequestBody Vet vet) throws Exception {
        id = vetServiceAPI.save(vet, id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteVet(@PathVariable String id) throws Exception {
        Vet vet = vetServiceAPI.get(id);
        if (vet != null)
            vetServiceAPI.delete(id);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(vet, HttpStatus.OK);
    }

}
