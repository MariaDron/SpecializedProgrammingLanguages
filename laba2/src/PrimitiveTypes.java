import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CLass for manipulations with primitives
 *
 * @author Maria Dron
 */
public class PrimitiveTypes {
    private int i1;
    private int i2;
    private static final String VALID_PATTERN = "\\D";

    public static void main(String[] args) {
        PrimitiveTypes primitives = new PrimitiveTypes();
        primitives.primitivesInit();
        primitives.primitivesCast();
        primitives.printVariables();
        primitives.printArrays();
        primitives.enumMatching();
        primitives.calculator();
        primitives.validation();
        primitives.setOfNumbers();
    }

    /**
     * Объявить переменные всех примитивных типов: без инициализации, инициализацией и с вычислением при инициализации.
     * Распечатать их значения (System.out.println(), System.out.printf()).
     * Целочисленные значения вывести в десятичном и шестнадцатеричном формате.
     */
    private void primitivesInit() {
        System.out.println("\n============================================\nTASK 1");
        byte b;
        byte initByte = 15;
        byte calculatedByte = 3 + 40;
        System.out.println("BYTE PRIMITIVE TYPE:");
        System.out.printf("decimal: \n\t%d\n\t%d\n\n", initByte, calculatedByte);
        System.out.printf("hex: \n\t0x%08X\n\t0x%08X\n\n", initByte, calculatedByte);

        short s;
        short initShort = 15;
        short calculatedShort = 3 + 40;
        System.out.println("SHORT PRIMITIVE TYPE:");
        System.out.printf("decimal: \n\t%d\n\t%d\n\n", initShort, calculatedShort);
        System.out.printf("hex: \n\t0x%08X\n\t0x%08X\n\n", initShort, calculatedShort);

        int i;
        int initInt = 15;
        int calculatedInt = 3 + 40;
        System.out.println("INT PRIMITIVE TYPE:");
        System.out.printf("decimal: \n\t%d\n\t%d\n\n", initInt, calculatedInt);
        System.out.printf("hex: \n\t0x%08X\n\t0x%08X\n\n", initInt, calculatedInt);

        long l;
        long initLong = 15;
        long calculatedLong = 3 + 40;
        System.out.println("LONG PRIMITIVE TYPE:");
        System.out.printf("decimal: \n\t%d\n\t%d\n\n", initLong, calculatedLong);
        System.out.printf("hex: \n\t0x%08X\n\t0x%08X\n\n", initLong, calculatedLong);

        float f;
        float initFloat = 15.15874f;
        float calculatedFloat = 3.6842545f + 40.15444154f;
        System.out.println("FLOAT PRIMITIVE TYPE:");
        System.out.printf("decimal: \n\t%f\n\t%f\n\n", initFloat, calculatedFloat);

        double d;
        double initDouble =15.15874;
        double calculatedDouble = 3.6842545 + 40.15444154;
        System.out.println("DOUBLE PRIMITIVE TYPE:");
        System.out.printf("decimal: \n\t%f\n\t%f\n\n", initDouble, calculatedDouble);

        boolean bool;
        boolean initBool = true;
        boolean calculatedBool = initByte == calculatedByte;
        System.out.println("BOOLEAN PRIMITIVE TYPE:");
        System.out.printf("\t%b\n\t%b\n\n", initBool, calculatedBool);

        char c;
        char initChar = 'c';
        char calculatedChar = 'c' + 'f';
        System.out.println("CHAR PRIMITIVE TYPE:");
        System.out.printf("\t%s\n\t%s\n\n", initChar, calculatedChar);
    }


    /**
     * Выполнить приведение целочисленных типов с допустимым расширением диапазона.
     * Выполнить приведение double к float, float к int с некорректным преобразованием (переполнением).
     */
    private void primitivesCast() {
        System.out.println("\n============================================\nTASK 2");
        byte b = 55;
        System.out.println(b);
        short s = b;
        System.out.println(s);
        int i = s;
        System.out.println(i);
        long l = i;
        System.out.println(l);

        double d = Double.MAX_VALUE;
        System.out.println(d);
        float f = (float) d;
        System.out.println(f);
        int castedInt = (int) f;
        System.out.println(castedInt);
    }

    /**
     * Объявить две переменные без инициализации: как поле класса и как локальную переменную в методе.
     * Вывести их на печать и пояснить отличие.
     */
    private void printVariables() {
        System.out.println("\n============================================\nTASK 3");
        int i1 = 5;
        int i2 = 6;
        System.out.printf("Locale var: %d %d\n", i1, i2);
        System.out.printf("Field of class: %d %d\n", this.i1, this.i2);
    }


    /**
     * Объявить массивы целых значений и строк. Вывести их на печать минимум двумя разными способами.
     */
    private void printArrays() {
        System.out.println("\n============================================\nTASK 4");
        int [] intArray = {1, 2, 3, 4, 5, 6 ,7, 8, 9};
        String [] stringArray = {"str1, str2, str3, str4, str5"};

        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();

        Arrays.asList(stringArray).forEach(str -> System.out.print(str + " "));
        System.out.println();

        int i = 0;
        do {
            System.out.print(intArray[i] + " ");
            i++;
        } while (i < intArray.length);
        System.out.println();
    }


    /**
     * Создать собственное перечисление (enum).
     * Ввести с клавиатуры целое число ( Scanner in = new Scanner( System.in ); int i = in.nextInt(); ),
     * сопоставить введенное целое со значением перечисления (использовать switch), значение перечисления распечатать на экране.
     */
    private void enumMatching(){
        System.out.println("\n============================================\nTASK 5");
        Scanner in = new Scanner( System.in );
        int i = in.nextInt();
        switch (i) {
            case 0:
                System.out.println((i == IntEnum.ZERO.ordinal()) ? IntEnum.ZERO + "(" + IntEnum.ZERO.ordinal() + ")" : null);
                break;
            case 1:
                System.out.println((i == IntEnum.ONE.ordinal()) ? IntEnum.ONE : null);
                break;
            case 2:
                System.out.println((i == IntEnum.TWO.ordinal()) ? IntEnum.TWO : null);
                break;
            case 3:
                System.out.println((i == IntEnum.THREE.ordinal()) ? IntEnum.THREE : null);
                break;
            default:
                System.out.println("Input value != any enum value");
                break;
        }
    }

    /**
     * Объявить целые, инициализировать их шестнадцатеричными значениями, распечатать,
     * выполнить знаковые и беззнаковые сдвиги, результат тоже распечатать. Пояснить разницу.
     */
    private void calculator() {
        System.out.println("\n============================================\nTASK 7");
        int value0 = 0x42;
        int value1 = 0x88;
        System.out.printf("Init int:\n\tvalue1 = 0x%08X\n\tvalue1 = 0x%08X\n", value0, value1);
        System.out.printf("Logical >>>:\n\tvalue1 = 0x%08X\n\tvalue1 = 0x%08X\n", (value0>>>2), (value1>>>3));
        System.out.printf("Arithmetic >>:\n\tvalue1 = 0x%08X\n\tvalue1 = 0x%08X\n", (value0>>2), (value1>>3));
        System.out.printf("Arithmetic <<:\n\tvalue1 = 0x%08X\n\tvalue1 = 0x%08X\n", (value0<<2), (value1<<3));
    }

    /**
     * Ввести целое значение с клавиатуры и проверить допустимость в рамках разрешенного диапазона
     * (например, количества этажей в доме, которые объявлены константой). Напечатать, корректно ли введенное значение.
     */
    private void validation() {
        System.out.println("\n============================================\nTASK 8");
        System.out.println("Please, input integer value (from 1 till 40)");
        Scanner in = new Scanner( System.in );
        String str = in.next();
        Matcher matcher = Pattern.compile(VALID_PATTERN).matcher(str);
        if (matcher.find()) {
            System.out.println("WARNING: Input value is not an integer number");
            return;
        }
        if ((Double.valueOf(str) % 1 == 0) && Integer.valueOf(str) >= 1 && Integer.valueOf(str) <= 40) {
            System.out.println("INFO: SUCCESS");
        } else {
            System.out.println("WARNING: The value is invalid (you should input the integer from 1 till 40)");
        }
    }

    /**
     * Напечатать множество неотрицательных нечетных чисел максимальной мощности, чье произведение меньше 10 000 (while).
     */
    private void setOfNumbers() {
        System.out.println("\n============================================\nTASK 9");
        int num = 0;
        while (true) {
            if (num*num <= 10000) {
                if (num >=0 && num % 2 ==1) {
                    System.out.print(num + " ");
                }
            } else {
                break;
            }
            num++;
        }
    }

    private void printList(List<Integer> list) {
        System.out.println();
        list.forEach(i -> System.out.print(i + " "));
    }
}
