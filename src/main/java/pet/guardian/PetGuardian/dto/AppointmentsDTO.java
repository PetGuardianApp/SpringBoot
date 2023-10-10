package pet.guardian.PetGuardian.dto;

import pet.guardian.PetGuardian.model.Appointments;

public class AppointmentsDTO extends Appointments {

    private String id;
    
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
