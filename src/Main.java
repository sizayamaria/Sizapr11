import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static String fileName = "text.txt"; // змінна для файлу

    public static void main(String[] args) {

        while (true) { // цикл працює поки користувач не вийде
            showMenu(); // показ меню

            try {
                int choice = Integer.parseInt(scanner.nextLine()); // введення числа

                if (choice == 1) {
                    writeToFile(); // запис у файл
                }
                else if (choice == 2) {
                    readFile(); // читання файлу
                }
                else if (choice == 3) {
                    System.out.println("Програма завершена");
                    break; // вихід з циклу
                }
                else {
                    throw new IllegalArgumentException("Невірний вибір");
                }

            } catch (NumberFormatException e) {
                System.out.println("Потрібно ввести число");
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void showMenu() { // меню
        System.out.println("Меню");
        System.out.println("1 - Записати у файл");
        System.out.println("2 - Прочитати файл");
        System.out.println("3 - Вийти");
        System.out.print("Ваш вибір: ");
    }

    public static void writeToFile() {

        try {
            System.out.println("Введіть текст:");
            String text = scanner.nextLine();

            if (text.length() == 0) {
                throw new IllegalArgumentException("Текст порожній");
            }

            FileWriter writer = new FileWriter(fileName, true); // дозапис у файл
            writer.write(text + "\n");
            writer.close();

            System.out.println("Текст записано");

        } catch (IOException e) {
            System.out.println("Помилка запису у файл");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readFile() {

        try {
            FileReader reader = new FileReader(fileName);

            int symbol;

            System.out.println("Вміст файлу:");

            while ((symbol = reader.read()) != -1) { // читання символів
                System.out.print((char) symbol);
            }

            System.out.println();
            reader.close();

        } catch (IOException e) {
            System.out.println("Помилка читання файлу");
        }
    }
}