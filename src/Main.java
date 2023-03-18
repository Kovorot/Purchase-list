import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static List<String> list = new ArrayList<>();
    public static void main(String[] args) {

        while (true) {
            System.out.println("Выберите одну из операций:");
            System.out.println("1. Добавить товар \n2. Показать список \n3. Удалить товар");
            int input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case 1:
                    add();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    delete();
                    break;
                default:
                    isWrong("number");
                    break;
            }
        }
    }

    public static void add() {
        System.out.println("Какую покупку хотите добавить?");
        String input = scanner.nextLine();
        list.add(input);
        System.out.println("Итого в списке покупок: " + list.size());
    }

    public static void show()  {
        showList();
    }

    public static void delete() {
        boolean isCatched = false;
        int numberInput = 0;
        String wordInput = null;
        showList();

        System.out.println("Какую хотите удалить? Введите номер или название");
        try {
            numberInput = Integer.parseInt(wordInput = scanner.nextLine());
        } catch (NumberFormatException e) {
            isCatched = true;
        }

        if(isCatched) {
            if(list.contains(wordInput)) {
                list.remove(wordInput);
                System.out.println("Покупка " + wordInput + " удалена, список покупок:");
                showList();
            } else {
                isWrong("word");
            }
        } else {
            try {
                System.out.println("Покупка " + list.get(numberInput - 1) + " удалена, список покупок:");
                list.remove(numberInput - 1);
                showList();
            } catch (IndexOutOfBoundsException e) {
                isWrong("number");
            }
        }
    }

    public static void showList() {
        if (list.isEmpty()) {
            System.out.println("В вашей корзине ничего нет");
        } else {
            int number = 1;
            System.out.println("Список покупок:");
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                System.out.println(number + " " + next);
                number++;
            }
        }
    }

    public static void isWrong(String meaning) {
        if (meaning.equals("word")) {
            System.out.println("Введено некорректное название");
        } else if (meaning.equals("number")) {
            System.out.println("Введен некорректный номер");
        }
    }
}