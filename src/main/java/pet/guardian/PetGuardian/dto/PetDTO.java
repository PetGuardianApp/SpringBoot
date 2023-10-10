package pet.guardian.PetGuardian.dto;

import pet.guardian.PetGuardian.model.Pet;

public class PetDTO extends Pet {

    private String id;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
