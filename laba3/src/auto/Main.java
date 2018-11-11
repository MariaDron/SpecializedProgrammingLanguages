package auto;

/**
 * @author Maria Dron
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Truck truck = new Truck();

        car.printName();
        car.printFuel();
        car.printPollution();
        car.printSpeed();
        car.printPassengers();

        System.out.println();

        truck.printName();
        truck.printFuel();
        truck.printPollution();
        truck.printSpeed();
        truck.printCargo();
    }
}
