package RestAssuredPOJO;
import java.util.*;

public class Courses {
    private List<WebAutomation> webAutomation;

    public List<WebAutomation> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(List<WebAutomation> webAutomation) {
        this.webAutomation = webAutomation;
    }

    public List<API> getApi() {
        return api;
    }

    public void setApi(List<API> api) {
        this.api = api;
    }

    public List<Mobile> getMobile() {
        return mobile;
    }

    public void setMobile(List<Mobile> mobile) {
        this.mobile = mobile;
    }

    private List<API> api;
    private List<Mobile> mobile;
}
