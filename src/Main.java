import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Выберите одну из операций:");
            System.out.println("1. Добавить товар 2. Показать список 3. Удалить товар");
            int input = Integer.parseInt(scanner.nextLine());
        }
    }

    public static void add() {
        System.out.println("Какую покупку хотите добавить?");
        String input = scanner.nextLine();
    }
}