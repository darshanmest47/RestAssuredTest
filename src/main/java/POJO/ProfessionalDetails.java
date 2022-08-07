package POJO;
import java.util.*;

public class ProfessionalDetails {

    public String getTotal_workduration() {
        return total_workduration;
    }

    public void setTotal_workduration(String total_workduration) {
        this.total_workduration = total_workduration;
    }

    public String getWork_location() {
        return work_location;
    }

    public void setWork_location(String work_location) {
        this.work_location = work_location;
    }

    public List<Organizations> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organizations> organizations) {
        this.organizations = organizations;
    }

    private String total_workduration;
    private String work_location;
    private List<Organizations> organizations;

}
