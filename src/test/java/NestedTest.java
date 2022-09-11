import NestedPOJO.CompanyDetailsPOJO;
import NestedPOJO.Contractorspojo;
import NestedPOJO.EmployeePOJO;
import NestedPOJO.NestedResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.*;

public class NestedTest {

    public static void main(String[] args) throws JsonProcessingException {
        //<---------------- Setters Code ------------------>
        //<--------------- Serialization ------------------>

        NestedResponse nes = new NestedResponse();

        nes.setCompanyName("MSE");
        nes.setCompanyCEO("Amod");
        nes.setCompanyHOCity("Benagluru");

        List<String> bankList = new ArrayList<String>();
        bankList.add("HDFC");
        bankList.add("ICICI");
        bankList.add("AXIS");
        nes.setSupportedSalaryBanks(bankList);

        List<Integer> pincodes = new ArrayList<Integer>();
        pincodes.add(560037);
        pincodes.add(360034);
        pincodes.add(456343);
        nes.setPincodesOfCityOffice(pincodes);

        EmployeePOJO emp1 = new EmployeePOJO();
        emp1.setFirstName("Amod");
        emp1.setLastName("Mahajan");
        emp1.setMarried(false);
        emp1.setGender("Male");
        emp1.setSalary(10000.56);
        emp1.setAge(28);

        EmployeePOJO emp2 = new EmployeePOJO();
        emp2.setFirstName("Animesh");
        emp2.setLastName("Prashant");
        emp2.setMarried(false);
        emp2.setGender("Male");
        emp2.setSalary(20000.56);
        emp2.setAge(30);

        EmployeePOJO emp3 = new EmployeePOJO();
        emp3.setFirstName("Kitty");
        emp3.setLastName("Gupta");
        emp3.setMarried(false);
        emp3.setGender("Female");
        emp3.setSalary(30000.56);
        emp3.setAge(26);

        List<EmployeePOJO> emplist = new ArrayList<EmployeePOJO>();
        emplist.add(emp1);
        emplist.add(emp2);
        emplist.add(emp3);
        nes.setEmployee(emplist);

        Contractorspojo con1 = new Contractorspojo();
        con1.setFirstName("Seema");
        con1.setLastName("Singh");
        con1.setContractFrom("Jan-2019");
        con1.setContractTo("JAN-2025");

        Contractorspojo con2 = new Contractorspojo();
        con2.setFirstName("Hari");
        con2.setLastName("Prasad");
        con2.setContractFrom("Jan-2017");
        con2.setContractTo("JAN-2030");
        List<Contractorspojo> conlist = new ArrayList<Contractorspojo>();
        conlist.add(con1);
        conlist.add(con2);
        nes.setContractors(conlist);

        CompanyDetailsPOJO cdetails = new CompanyDetailsPOJO();
        cdetails.setPfCity("Benagluru");
        cdetails.setNoOfEmployees(10);
        cdetails.setPfYear(2012);
        cdetails.setPfName("XYZ");
        nes.setCompanyPFDeails(cdetails);

        ObjectMapper obj = new ObjectMapper();
        String finalResponse = obj.writerWithDefaultPrettyPrinter().writeValueAsString(nes);
        System.out.println(finalResponse);

        //<---------------- Getters Code ------------------>
        //<--------------- DeSerialization ------------------>

        System.out.println(nes.getCompanyName());
        System.out.println(nes.getCompanyHOCity());
        System.out.println(nes.getCompanyCEO());
        System.out.println("\n");

        List<String> supportedBanks = nes.getSupportedSalaryBanks();
        for(String banks:supportedBanks){
            System.out.println(banks);

        }
        System.out.println("\n");
        List<Integer> pincodesOfCities = nes.getPincodesOfCityOffice();
        for(Integer pincodesOfcity:pincodesOfCities){
            System.out.println(pincodesOfcity);
        }
        System.out.println("\n");
        List<EmployeePOJO> emps = nes.getEmployee();
        for(EmployeePOJO e:emps){
            System.out.println(e.getFirstName());
            System.out.println(e.getLastName());
            System.out.println(e.getAge());
            System.out.println(e.getGender());
            System.out.println(e.getSalary());
            System.out.println(e.isMarried());
            System.out.println("\n");
        }
        System.out.println("\n");

        List<Contractorspojo> contractors = nes.getContractors();
        for(Contractorspojo c:contractors){
            System.out.println(c.getFirstName());
            System.out.println(c.getLastName());
            System.out.println(c.getContractFrom());
            System.out.println(c.getContractTo());
            System.out.println("\n");
        }
        System.out.println("\n");

        CompanyDetailsPOJO cpfdetails = nes.getCompanyPFDeails();
        System.out.println(cpfdetails.getPfName());
        System.out.println(cpfdetails.getPfCity());
        System.out.println(cpfdetails.getNoOfEmployees());
        System.out.println(cpfdetails.getPfYear());



    }
}
