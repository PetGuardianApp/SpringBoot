package pet.guardian.PetGuardian.model;

import java.util.HashMap;
import java.util.Map;

public class Pets {
    String birth;
    String breed;
    Map<String,Integer> weight = new HashMap<>();
    Map<Object, Object> health_info = new HashMap<>();
    Integer height;
    String name;
    String type;

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

    public Map<String, Integer> getWeight() {
        return weight;
    }

    public void setWeight(Map<String, Integer> weight) {
        this.weight = weight;
    }

     public Map<Object,Object> getHealth_info() {
        return this.health_info;
    }

    public void setHealth_info(Map<Object,Object> health_info) {
        this.health_info = health_info;
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
}
