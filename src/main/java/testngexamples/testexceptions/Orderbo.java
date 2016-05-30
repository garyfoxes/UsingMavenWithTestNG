package testngexamples.testexceptions;

/**
 * Created by gfox on 06/05/2016.
 */
public class Orderbo {

    public void save(Order r) throws OrderSaveException {
        if (r == null) {
            throw new OrderSaveException("Order is null or empty");
        }
    }

    public void update(Order r) throws OrderUpdateException {
        if (null == r.getDate()) {
            throw new OrderUpdateException("Cannot update Order, Order is null or empty");
        }
        r.setCreatedBy("Joe");
    }
}

class Order {

    private int id;
    private String name;
    private String date;

    public void setId(int id) {
        this.id = id;
    }

    public void setCreatedBy(String name) {
        this.name = name;
    }

    public String getDate() {
        return this.date;
    }
}

class OrderSaveException extends Exception {

    public OrderSaveException(String message) {
        super(message);
    }
}

class OrderUpdateException extends Exception {

    public OrderUpdateException(String message) {
        super(message);
    }
}