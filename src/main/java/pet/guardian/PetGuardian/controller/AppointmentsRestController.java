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

import pet.guardian.PetGuardian.model.Appointments;
import pet.guardian.PetGuardian.service.api.AppointmentsServiceAPI;

@RestController
@RequestMapping(value = "/appointment")
@CrossOrigin("*")
public class AppointmentsRestController {

    @Autowired
    private AppointmentsServiceAPI appointmentsServiceAPI;

    @GetMapping(value = "/all")
    public List<Appointments> getAllAppointment() throws Exception {
        return appointmentsServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public Appointments findAppointment(@PathVariable String id) throws Exception {
        return appointmentsServiceAPI.get(id);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createAppointment(@RequestBody Appointments appointment) throws Exception {
        String id = appointmentsServiceAPI.save(appointment);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAppointment(@PathVariable String id, @RequestBody Appointments appointment) throws Exception {
        id = appointmentsServiceAPI.save(appointment, id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Appointments> deleteAppointment(@PathVariable String id) throws Exception {
        Appointments appointment = appointmentsServiceAPI.get(id);
        if (appointment != null)
            appointmentsServiceAPI.delete(id);
        else
            return new ResponseEntity<Appointments>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<Appointments>(appointment, HttpStatus.OK);
    }
    
}
