package testngexamples.dataprovider;

/**
 * Created by gfox on 04/05/2016.
 */
public class TestObject {

    private String name;
    private int age;
    private String location;
    private boolean married;

    public TestObject(String name, int age, String location, boolean married) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.married = married;
    }

    public double getPredictedIncome() {
        if (this.age > 17 && this.age < 90) {
            if (married) {
                return 40000;
            } else {
                return 60000;
            }
        } else {
            return 0.0;
        }
    }
}
