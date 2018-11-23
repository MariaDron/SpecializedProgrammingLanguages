import exceptions.ExceededLimitException;
import exceptions.NonNumberException;
import exceptions.NumericException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author MariaDron
 */
public class Main {

    private static final String CHAR_IS_NUMBER = "[0-9]";
    private static final String CHAR_UPPER_CASE = "[A-Z]";
    private static final String CHAR_LOWER_CASE = "[a-z]";
    private static final String CHAR_IS_WHITESPACE = "\\s";

    public static void main(String[] args) {
        Main main = new Main();
        /*main.unitStrings();
        main.strValidator("jhY45 *b5");
        main.copyFile("laba5/first.txt", "laba5/second.txt");*/
        //main.printFileDump();
        //main.testCustomCloseableClass();
        try {
            main.cascading();
        } catch (NumericException e) {
            e.printStackTrace();
        }
    }

    /**
     * С клавиатуры ввести несколько слов (фраз), объединить их через StringBuilder
     * (каждый раз выводя на печать текущую емкость), распечатать итоговое значение.
     */
    private void unitStrings() {
        System.out.println("============================================\nTASK 1");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number of words");
        int count = scanner.nextInt();
        List<String> wordsList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            wordsList.add(scanner.next());
        }

        for (String word : wordsList) {
            stringBuilder.append(word);
            System.out.print(stringBuilder + " ");
        }
    }

    /**
     * Перебирая символы строки, распечатать информацию о каждом: является ли цифрой,
     * символом (верхнего или нижнего регистра) или пробелом.
     */
    private void strValidator(String str) {
        System.out.println("============================================\nTASK 2");

        for (Character c : str.toCharArray()) {
            if (Pattern.compile(CHAR_IS_NUMBER).matcher(String.valueOf(c)).find())
                System.out.println("The character '" + c + "' is a number");
            if (Pattern.compile(CHAR_UPPER_CASE).matcher(String.valueOf(c)).find())
                System.out.println("The character '" + c + "' is a char i upper case");
            if (Pattern.compile(CHAR_LOWER_CASE).matcher(String.valueOf(c)).find())
                System.out.println("The character '" + c + "' is a char i lower case");
            if (Pattern.compile(CHAR_IS_WHITESPACE).matcher(String.valueOf(c)).find())
                System.out.println("The character '" + c + "' is a char i whitespace");
        }
    }

    /**
     * Реализовать программу, которая получает два имени текстовых файлов через параметр командной строки,
     * затем выполняет копирование одного файла в другой, без использования системных функций копирования
     * (открывать, читать и записывать данные - самостоятельно, через классы FileInputStream, FileOutputStream,
     * PrintWriter, FileWriter и т.п.). Использовать автозакрытие файлов через try(), обрабатывать ошибки ввода-вывода
     * (печатать про них информацию).
     */
    private void copyFile(String fileName, String fileNameCopy) {
        System.out.println("============================================\nTASK 3");
        try (FileOutputStream outputStream = new FileOutputStream(fileNameCopy);
             FileInputStream inputStream = new FileInputStream(fileName)) {
            int i;
            byte[] buf = new byte[8192];
            while((i = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Разработать программу, запрашивающую имя файла у пользователя, затем печатающего содержимое файла как
     * шестнадцатеричный дамп на экране. В случае возникновения ошибки (файл не найден, запрет доступа)
     * программа также печатает сообщение об ошибке. В конце работы программа в любом случае выводит сообщение (любое)
     * о завершении собственной работы.
     */
    private void printFileDump() {
        System.out.println("============================================\nTASK 4");
        System.out.print("Input a filename: ");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.next();
        System.out.println();

        try (FileInputStream inputStream = new FileInputStream(filename)) {
            byte[] buf = new byte[15];
            int i;
            while((i = inputStream.read(buf)) !=-1) {
                if (i < 15) {
                    buf = Arrays.copyOf(buf, i);
                }
                for (byte b : buf) {
                    System.out.printf("0x%08X ", b);
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File wasn't found");
        } catch (IOException e) {
            System.out.println("ERROR: Exception was thrown while workin with stream");
        }
        System.out.println("The program finished the work!");
    }

    private void testCustomCloseableClass() {
        System.out.println("============================================\nTASK 5");
        try (CloseableImpl closeableImpl = new CloseableImpl()) {
            System.out.println("I'm in try block");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Каскадирование: разработать три собственных класса, реализующих исключения. В блоке try {},
     * в зависимости от пользовательского ввода, выбросить одно из двух. Перехватывать оба возможных варианта,
     * в обработчике выбросить третье исключение и позже перехватить его. На финальном этапе (перехвате третьего)
     * распечатать стек вызовов каждого из перехваченных исключений.
     */
    private void cascading() throws NumericException {
        System.out.println("============================================\nTASK 6");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a number <= 90: ");
        try {
            String value = scanner.next();
            if (!Pattern.compile(CHAR_IS_NUMBER).matcher(String.valueOf(value)).find()) {
                throw new NonNumberException("The value is not a number");
            }
            if (Double.valueOf(value) > 90) {
                throw new ExceededLimitException("The value > 90");
            }
        } catch (NonNumberException | ExceededLimitException ex) {
            throw new NumericException(ex.getMessage());
        }
        System.out.println("Well done! You are right.");
    }
}
