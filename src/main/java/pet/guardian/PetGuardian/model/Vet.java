package pet.guardian.PetGuardian.model;

import com.google.cloud.firestore.GeoPoint;

public class Vet {
    GeoPoint clinic_address;
    String email;
    String name;
    String surname;
    Integer phone;

    public GeoPoint getClinic_address() {
        return clinic_address;
    }

    public void setClinic_address(GeoPoint clinic_address) {
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
