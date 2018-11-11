package auto;

public class Car extends Auto {
    private int passengers;

    public Car() {
        name = "Car";
        speed = 210;
        fuelConsumption = 10;
        pollution = 6;
        passengers = 4;
    }

    public void printPassengers() {
        System.out.println("Car transported passengers: " + passengers);
    }
}
