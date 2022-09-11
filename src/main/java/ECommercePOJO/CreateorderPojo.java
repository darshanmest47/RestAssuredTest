package ECommercePOJO;
import java.util.List;

public class CreateorderPojo {
    public List<Orders> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    private List<Orders>orders;

}
