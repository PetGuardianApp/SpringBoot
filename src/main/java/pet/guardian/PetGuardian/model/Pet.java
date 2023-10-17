package pet.guardian.PetGuardian.model;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class Pet {
    String birth;
    String breed;
    Map<String, String> weight = new HashMap<>();
    Map<String, Object> health_info = new HashMap<>();
    Integer height;
    String name;
    String type;
    String vet_id;
    String client_id;
    private String profile_image;

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Map<String, String> getWeight() {
        return weight;
    }

    public void setWeight(Map<String, String> weight) {
        this.weight = weight;
    }

    public Map<String, Object> getHealth_info() {
        return this.health_info;
    }

    public void setHealth_info(Map<String, Object> health_info) {
        this.health_info = health_info;
    }

    public void addHealth_InfoElement(Map<String,Object> entry){
        this.health_info.putAll(entry);
    }


    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVet_id() {
        return vet_id;
    }

    public void setVet_id(String vet_id) {
        this.vet_id = vet_id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
}
