package pet.guardian.PetGuardian.model;

public class Appointments {

    private String end_date;

    private String matter;

    private String observations;

    private String start_date;

    private String pet_id;


    public String getEnd_date() {
        return this.end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getMatter() {
        return this.matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public String getObservations() {
        return this.observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getStart_date() {
        return this.start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getPet_id() {
        return this.pet_id;
    }

    public void setPet_id(String pet_id) {
        this.pet_id = pet_id;
    }

}
