package auto;

/**
 * @author Maria Dron
 */
public class Car extends Auto {
    private int passengers;

    public Car() {
        name = "Car";
        speed = 210;
        fuelConsumption = 10;
        pollution = 6;
        passengers = 4;
    }

    @Override
    protected void printName() {
        System.out.println("Car name: " + name);
    }

    public void printPassengers() {
        System.out.println("Car transported passengers: " + passengers);
    }
}
