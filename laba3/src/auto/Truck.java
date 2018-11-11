package auto;

/**
 * @author Maria Dron
 */
public class Truck extends Auto {
    private int cargo;

    public Truck() {
        name = "Truck";
        speed = 150;
        fuelConsumption = 25;
        pollution = 17;
        cargo = 3;
    }

    @Override
    protected void printName() {
        System.out.println("Truck name: " + name);
    }

    public void printCargo() {
        System.out.println("Truck transported cargo: " + cargo + " t");
    }
}
