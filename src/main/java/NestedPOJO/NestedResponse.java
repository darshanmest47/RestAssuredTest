package NestedPOJO;
import java.util.*;

public class NestedResponse {

    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyHOCity() {
        return companyHOCity;
    }

    public void setCompanyHOCity(String companyHOCity) {
        this.companyHOCity = companyHOCity;
    }

    public String getCompanyCEO() {
        return companyCEO;
    }

    public void setCompanyCEO(String companyCEO) {
        this.companyCEO = companyCEO;
    }

    public List<String> getSupportedSalaryBanks() {
        return supportedSalaryBanks;
    }

    public void setSupportedSalaryBanks(List<String> supportedSalaryBanks) {
        this.supportedSalaryBanks = supportedSalaryBanks;
    }

    public List<Integer> getPincodesOfCityOffice() {
        return pincodesOfCityOffice;
    }

    public void setPincodesOfCityOffice(List<Integer> pincodesOfCityOffice) {
        this.pincodesOfCityOffice = pincodesOfCityOffice;
    }

    public List<EmployeePOJO> getEmployee() {
        return employee;
    }

    public void setEmployee(List<EmployeePOJO> employee) {
        this.employee = employee;
    }

    public List<Contractorspojo> getContractors() {
        return contractors;
    }

    public void setContractors(List<Contractorspojo> contractors) {
        this.contractors = contractors;
    }

    public CompanyDetailsPOJO getCompanyPFDeails() {
        return companyPFDeails;
    }

    public void setCompanyPFDeails(CompanyDetailsPOJO companyPFDeails) {
        this.companyPFDeails = companyPFDeails;
    }

    private String companyHOCity;
    private String companyCEO;
    private List<String> supportedSalaryBanks;
    private List<Integer>pincodesOfCityOffice;
    private List<EmployeePOJO>employee;
    private List<Contractorspojo>contractors;
    private CompanyDetailsPOJO companyPFDeails;
}
