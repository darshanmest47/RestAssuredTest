package POJO;
import java.util.*;

public class Main {


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }

    public List<ProfessionalDetails> getProfessional_details() {
        return professional_details;
    }

    public void setProfessional_details(List<ProfessionalDetails> professional_details) {
        this.professional_details = professional_details;
    }

    private String age;
    private String name;
    private String email;
    private List<Country> country;
    private List<ProfessionalDetails> professional_details;


}
