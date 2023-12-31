package pet.guardian.PetGuardian.model;

import java.util.HashMap;
import java.util.Map;

public class Vet {
    Map<String,String> clinic_address = new HashMap<>();
    String email;
    String name;
    String surname;
    Integer phone;
    String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getClinic_address() {
        return clinic_address;
    }

    public void setClinic_address(Map<String, String> clinic_address) {
        this.clinic_address = clinic_address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}
