package testngexamples.testexceptions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by gfox on 06/05/2016.
 */
public class TestExceptions {

    Orderbo orderBo;
    Order order;

    @BeforeTest
    public void beforeTest() {
        order = new Order();
        order.setId(2);
        order.setCreatedBy("Gary");
        orderBo = new Orderbo();
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divisionExceptions() {
        int i = 1 / 0;
    }

    @Test(expectedExceptions = OrderSaveException.class)
    public void throwOrderSaveNull() throws OrderSaveException {
        orderBo.save(null);
    }

    @Test(expectedExceptions = OrderUpdateException.class)
    public void throwOrderUpdateNull() throws OrderUpdateException {
        orderBo.update(order);
    }
}
