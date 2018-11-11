package auto;

/**
 * Сделать абстрактный класс “автомобиль” и его наследников (“легковой”, “грузовой” и т.п.),
 * продемонстрировать полиморфные методы (вывод названия автомобиля, перемещение за единицу времени,
 * вывод потребленного топлива, перевезенного груза и пассажиров, загрязнение окружающей среды;
 * предусмотреть возможности для электромобилей).
 */
public abstract class Auto {
    protected String name;
    protected double speed;
    protected double fuelConsumption;
    protected double pollution;

    public Auto () {
        name = "Auto";
        speed = 80.5;
        fuelConsumption = 8;
        pollution = 5.3;
    }

    protected void printName() {
        System.out.println("Auto name: " + name);
    }

    protected void printSpeed() {
        System.out.println("Auto speed: " + speed + " km/h");
    }

    protected void printFuel() {
        System.out.println("Auto fuel consumption: " + fuelConsumption + " l/km");
    }

    protected void printPollution() {
        System.out.println("Auto pollution: " + fuelConsumption + " mg/m3");
    }
}
