package pet.guardian.PetGuardian.dto;

import pet.guardian.PetGuardian.model.Pets;

public class PetsDTO extends Pets {

    private String id;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
