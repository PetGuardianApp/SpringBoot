package pet.guardian.PetGuardian.model;

import java.util.HashMap;
import java.util.List;
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

    @SuppressWarnings("unchecked")
    public void addHealth_InfoElement(Map<String, Object> entry) {
        for (Map.Entry<String, Object> element : entry.entrySet()) {
            switch (element.getKey()) {
                case "observations":
                    String observation_new = (String) element.getValue();
                    this.health_info.put("observations", observation_new);
                    break;
                case "cardiac_freq":
                    Map<String, String> cardiac_freq_new = (Map<String, String>) element.getValue();
                    Map<String, String> cardiac_freq_actual = (Map<String, String>) this.health_info
                            .get("cardiac_freq");
                    for (Map.Entry<String, String> elem_cardiac_freq : cardiac_freq_new.entrySet()) {
                        String key = elem_cardiac_freq.getKey(); // Get the key
                        String value = elem_cardiac_freq.getValue(); // Get the value
                        cardiac_freq_actual.put(key, value);
                    }
                    break;
                case "steps":
                    Map<String, String> steps_new = (Map<String, String>) element.getValue();
                    Map<String, String> steps_actual = (Map<String, String>) this.health_info
                            .get("steps");
                    for (Map.Entry<String, String> elem_steps : steps_new.entrySet()) {
                        String key = elem_steps.getKey(); // Get the key
                        String value = elem_steps.getValue(); // Get the value
                        steps_actual.put(key, value);
                    }
                    break;
                case "vaccines":
                    List<String> vaccines_new = (List<String>) element.getValue();
                    List<String> vaccines_actual = (List<String>) this.health_info.get("vaccines");
                    for (String vaccine : vaccines_new) {
                        vaccines_actual.add(vaccine);
                    }
                    break;
            }
        }
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
