package ECommercePOJO;

import java.util.List;

public class Orders {


    private String country;

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProductOrderedId() {
        return this.productOrderedId;
    }

    public void setProductOrderedId(String productOrderedId) {
        this.productOrderedId = productOrderedId;
    }

    private String productOrderedId;
}
