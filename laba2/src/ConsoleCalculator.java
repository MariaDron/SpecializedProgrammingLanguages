import java.util.Scanner;

/**
 * Объявить константы (по собственному выбору). Сделать консольный мини-калькулятор (перевод дюймов в сантиметры,
 * увеличение скорости в вакууме в зависимости от времени свободного падения и т.п. )
 *
 * @author Maria Dron
 */
public class ConsoleCalculator {
    private static final double smToInch = 0.39;
    private static final double inchToSm = 2.54;
    private static final double freeFall = 9.832;

    public static void main(String[] args) {
        System.out.println("\n============================================\nTASK 6");
        ConsoleCalculator calculator = new ConsoleCalculator();
        Scanner in = new Scanner( System.in );
        int i;
        while(true) {
            System.out.println("1. Convert sm to inch\n"
                    + "2. Convert ich to sm\n"
                    + "3. Calculate free fall increase\n");
            i = in.nextInt();
            switch (i) {
                case 1:
                    System.out.println("Please, input the value in sm");
                    double sm = in.nextDouble();
                    System.out.println(sm + " sm = " + calculator.convertSmToInch(sm) + " inch");
                    break;
                case 2:
                    System.out.println("Please, input the value in inch");
                    double inch = in.nextDouble();
                    System.out.println(inch + " inch = " + calculator.convertInchToSm(inch) + " sm");
                    break;
                case 3:
                    System.out.println("Please, input the value in time");
                    double time = in.nextDouble();
                    System.out.println("Free fall increase = " + calculator.calculateIncreaseFreeFall(time));
                    break;
                default:
                    System.out.println("ERROR");
            }
        }
    }

    private double convertSmToInch(double sm){
        return sm * smToInch;
    }

    private double convertInchToSm(double inch){
        return inch / inchToSm;
    }

    private double calculateIncreaseFreeFall(double time) {
        return freeFall * time;
    }
}
