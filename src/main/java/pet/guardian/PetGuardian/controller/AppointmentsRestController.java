package pet.guardian.PetGuardian.controller;

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
import pet.guardian.PetGuardian.model.Pet;
import pet.guardian.PetGuardian.service.api.AppointmentsServiceAPI;

@RestController
@RequestMapping(value = "/appointment")
@CrossOrigin("*")
public class AppointmentsRestController {

    @Autowired
    private AppointmentsServiceAPI appointmentsServiceAPI;

    @GetMapping(value = "/all")
    public ResponseEntity<Object> getAllAppointment() throws Exception {
        return new ResponseEntity<>(appointmentsServiceAPI.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Object> findAppointment(@PathVariable String id) throws Exception {
        return new ResponseEntity<Object>(appointmentsServiceAPI.get(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createAppointment(@RequestBody Appointments appointment) throws Exception {
        String id = appointmentsServiceAPI.save(appointment);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAppointment(@PathVariable String id, @RequestBody Appointments appointment) throws Exception {
        Appointments new_appointment = patchAppointments(appointmentsServiceAPI.get(id),appointment);
        return new ResponseEntity<>(appointmentsServiceAPI.save(new_appointment, id), HttpStatus.OK);
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

    private Appointments patchAppointments(Appointments appointmentToUpdate, Appointments appointment) {
        if (appointment.getEnd_date() != null)
            appointmentToUpdate.setEnd_date(appointment.getEnd_date());
        if (appointment.getMatter() != null)
            appointmentToUpdate.setMatter(appointment.getMatter());
        if (appointment.getObservations() != null)
            appointmentToUpdate.setObservations(appointment.getObservations());
        if (appointment.getStart_date() != null)
            appointmentToUpdate.setStart_date(appointment.getStart_date());
        if (appointment.getPet_id() != null)
            appointmentToUpdate.setPet_id(appointment.getPet_id());
        return appointmentToUpdate;
    }
    
}
