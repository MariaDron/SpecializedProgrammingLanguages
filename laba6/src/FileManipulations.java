import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class FileManipulations {
    private static final String INPUT_FILE_NAME = "laba6/input.txt";
    private static final String OUTPUT_FILE_NAME = "laba6/output.txt";
    private static final String BINARY_FILE_NAME = "laba6/binary.txt";
    private static final String TEST_FILE_NAME = "laba6/test.txt";
    private static final String VALID_LOGIN = "test_login@gmail.com";
    private static final String VALID_PASSWORD = "Test123*";
    private static final String FILE_PATH = "laba6/";
    private static final String ZIP_EXT = ".zip";
    private static final String ZIP_ARCHIVE = FILE_PATH + "archive.zip";
    private static final String END_OF_ZIPFILE_INPUT = "Q!";

    public static void main(String[] args) {
        FileManipulations fileManipulations = new FileManipulations();
        fileManipulations.getAllWords();
        fileManipulations.credentialValidation();
        fileManipulations.objectStreams();
        fileManipulations.fileDataManipulation();
        fileManipulations.zipOperation();
        fileManipulations.zipArchive();
    }

    /**
     * Из текстового файла, содержащего слова (состоящие из латинских букв A-Z в разных регистрах),
     * знаки препинания (,.!?-), пробелы, цифры и спецсимволы (“№;%:*()+) извлечь все слова и записать в выходной файл,
     * разделенные пробелами.
     */
    private void getAllWords() {
        System.out.println("============================================\nTASK 1");
        try (FileWriter writer = new FileWriter(OUTPUT_FILE_NAME);
            BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_NAME))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            Matcher matcher;
            boolean flag = true;
            while((line = reader.readLine()) != null) {
                matcher = Pattern.compile("[^A-Za-z]").matcher(line);
                if (matcher.find()) {
                    for(char c : line.toCharArray()) {
                        if (Pattern.compile("[A-Z|a-z]").matcher(String.valueOf(c)).find()) {
                            stringBuilder.append((!flag) ? " " : "").append(c);
                            flag = true;
                        } else {
                            flag = false;
                        }
                    }
                }
            }

            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Запросить у пользователя логин и пароль (пароль - не отображаемый на экране). Выполнить примитивное хэширование
     * (сложить все символы как 16-битовые целые, умножая предыдущий результат на 5 и добавляя к сумме 7 для каждого
     * символа пароля). Сравнить с заранее заданным в программе значением, и по результату напечатать
     * “доступ предоставлен” или “в доступе отказано”.
     */
    private void credentialValidation() {
        System.out.println("============================================\nTASK 2");
        int validCredHash = credentialsHash(VALID_LOGIN, VALID_PASSWORD);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Login: ");
        String login = scanner.next();
        System.out.print("Password: ");
        String pass = (System.console() == null) ? scanner.next()
                : String.valueOf(System.console().readPassword());

        int credHash = credentialsHash(login, pass);
        if (credHash == validCredHash)
            System.out.println("Access is granted");
        else
            System.out.println("Access denied");

    }

    private int credentialsHash(String login, String pass) {
        int hash = 0;
        for (char c : login.toCharArray())
            hash += c * 5;
        for (char c : pass.toCharArray())
            hash += c * 5 + 7;
        return hash;
    }

    /**
     * Сохранить в одном двоичном файле (последовательно): целое число, булево значение, строку с латинскими и
     * кириллическими буквами, два объекта, в полях которых также присутствуют классы (String, Long и т.п.).
     * Из этого файла прочесть значения и распечатать их на экране (для классов - содержимое их полей).
     */
    private void objectStreams() {
        System.out.println("============================================\nTASK 3");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(BINARY_FILE_NAME));
             FileInputStream fileInputStream = new FileInputStream(BINARY_FILE_NAME);
             ObjectInputStream inputStream = new ObjectInputStream(fileInputStream)) {
            outputStream.writeObject(64);
            outputStream.writeObject(true);
            outputStream.writeObject("vbdjkshтыофшг");
            outputStream.writeObject(new ExampleObject());
            outputStream.writeObject(new ExampleObject());

            while (fileInputStream.available() > 0) {
                System.out.println(inputStream.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Записать в файл массив из 64 байт, закрыть его. Открыть файл на запись, изменить знак каждого байта с четным
     * индексом (0-го, 2-го, 4-го и т.д.), не перезаписывая весь файл, а только конкретные значения, закрыть файл.
     * Открыть файл на чтение, прочесть массив целиком и распечатать его.
     */
    private void fileDataManipulation() {
        System.out.println("============================================\nTASK 4");
        byte[] byteArray = new byte[64];
        new Random().nextBytes(byteArray);
        System.out.println("Primordial array:\n" + Arrays.toString(byteArray));
        try {
            RandomAccessFile raf = new RandomAccessFile(TEST_FILE_NAME, "rw");
            raf.write(byteArray);
            raf.close();

            raf = new RandomAccessFile(TEST_FILE_NAME, "rw");
            for (int i = 0; i < byteArray.length; i++) {
                if (i%2 == 0) {
                    raf.seek(i);
                    raf.write(byteArray[i]* (-1));
                }
            }
            raf.close();

            raf = new RandomAccessFile(TEST_FILE_NAME, "r");
            raf.read(byteArray);
            raf.close();
            System.out.println("Array after changes:\n" + Arrays.toString(byteArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Запросить у пользователя имя архива, создать такой ZIP-файл в текущем каталоге. Далее итеративно запрашивать имя нового файла в архиве,
     * добавлять данные, введенные пользователем с клавиатуры, в этот файл. Признак того, что ввод текущего файла (внутри архива) завершен - “q!”
     * в самом начале строки. Признак того, что завершен ввод и текущего файла, и всего архива - “Q!” в самом начале строки.
     * Проверить созданных архив (список файлов внутри, и содержание каждого из вложенных файлов) с помощью стандартной программы архивации.
     */
    private void zipOperation() {
        System.out.println("============================================\nTASK 5");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input zip name: ");
        String zipName = scanner.next();
        String fileName;
        String fileData;
        try (ZipOutputStream zipOutputStream =
                     new ZipOutputStream(new FileOutputStream(FILE_PATH + zipName + ZIP_EXT))) {
            while(true) {
                System.out.print("Input file name: ");
                fileName = scanner.next();
                if (fileName.equals(END_OF_ZIPFILE_INPUT))
                    break;
                System.out.print("Input file data: ");
                fileData = scanner.next();

                File file = new File(FILE_PATH + fileName);
                FileOutputStream outputStream = new FileOutputStream(file);
                outputStream.write(fileData.getBytes());

                zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileManipulations fm = new FileManipulations();
        fm.zipExtract(zipName);
    }

    private void zipExtract(String zipFileName) {
        InputStream inputStream = null;
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(FILE_PATH + zipFileName + ZIP_EXT);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            final byte[] buffer = new byte[4];
            while(entries.hasMoreElements()){
                ZipEntry zipEntry = entries.nextElement();
                System.out.printf("\nFile name: %s\n", zipEntry.getName());
                inputStream = zipFile.getInputStream(zipEntry);
                System.out.print("\tFile data: ");
                System.out.print("Hello!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                zipFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * С помощью стандартной программы архивации создать ZIP-архив, содержащий файлы, без каталогов. Написать программу,
     * принимающую имя архива как параметр командной строки (запуск - java программа имя_архива.zip) и извлекающего все файлы в текущий каталог.
     */
    private void zipArchive() {
        System.out.println("============================================\nTASK 6");
        archive(3);
        extractToCurrentDir();
    }

    private void archive(int count) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(ZIP_ARCHIVE))) {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                FileWriter filewriter = new FileWriter("file" + i + ".txt");
                char[] buffer = new char[64];
                for (int j = 0; j < 64; j++)
                    buffer[j] = (char)(random.nextInt(26) + 'a');
                filewriter.write(buffer);
                filewriter.flush();
                zipOutputStream.putNextEntry(new ZipEntry("file" + i + ".txt"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void extractToCurrentDir() {
        InputStream inputStream = null;
        ZipFile zipFile = null;
        OutputStream outputStream = null;
        try {
            zipFile = new ZipFile(ZIP_ARCHIVE);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            byte[] buffer = new byte[64];
            while(entries.hasMoreElements()){
                ZipEntry zipEntry = entries.nextElement();
                inputStream = zipFile.getInputStream(zipEntry);
                outputStream = new FileOutputStream(Paths.get("").toAbsolutePath().toString()
                        + "\\laba6\\" + zipEntry.getName());
                while (inputStream.available() > 0) {
                    inputStream.read(buffer);
                    outputStream.write(buffer);
                    outputStream.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
                zipFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
