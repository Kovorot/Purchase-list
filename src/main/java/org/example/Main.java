package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("Выберите одну из операций:");
            System.out.println("1. Добавить товар \n2. Показать список \n3. Удалить товар \n4. Поиск товара");
            int input = Integer.parseInt(scanner.nextLine());
            String value;

            switch (input) {
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    value = scanner.nextLine();
                    add(value);
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    System.out.println("Введите текст для поиска:");
                    value = scanner.nextLine();
                    search(value);
                    break;
                default:
                    isWrong("number");
                    break;
            }
        }
    }

    //Добавление товара
    public static String add(String input) {
        list.add(input);
        System.out.println("Итого в списке покупок: " + list.size());
        return input;
    }

    //Показывает список выбранных товаров
    public static void show() {
        showList(list);
    }

    //Удаление товара из списка
    public static void delete() {
        boolean isCatched = false;
        int numberInput = 0;
        String wordInput = null;
        showList(list);

        System.out.println("Какую хотите удалить? Введите номер или название");
        try {
            numberInput = Integer.parseInt(wordInput = scanner.nextLine());
        } catch (NumberFormatException e) {
            isCatched = true;
        }

        if (isCatched) {
            if (list.contains(wordInput)) {
                list.remove(wordInput);
                System.out.println("Покупка " + wordInput + " удалена, список покупок:");
                showList(list);
            } else {
                isWrong("word");
            }
        } else {
            try {
                System.out.println("Покупка " + list.get(numberInput - 1) + " удалена, список покупок:");
                list.remove(numberInput - 1);
                showList(list);
            } catch (IndexOutOfBoundsException e) {
                isWrong("number");
            }
        }
    }

    //Поиск товара по названию
    public static String search(String input) {
        input = input.toLowerCase();
        int number = 1;
        System.out.println("Найдено:");
        for (String title : list) {
            title = title.toLowerCase();
            if (title.contains(input)) {
                System.out.println(number + " " + list.get(number - 1));
            }
            number++;
        }
        return input;
    }

    //Показывает список товаров (дополнительный метод для избежания дублирования кода)
    public static boolean showList(List list) {
        boolean isEmpty;
        if (list.isEmpty()) {
            System.out.println("В вашей корзине ничего нет");
            isEmpty = true;
        } else {
            int number = 1;
            System.out.println("Список покупок:");
            Iterator<String> iterator = list.iterator();
            isEmpty = false;
            while (iterator.hasNext()) {
                String next = iterator.next();
                System.out.println(number + " " + next);
                number++;
            }
        }
        return isEmpty;
    }

    //Сообщение о вводе некорректного значения
    public static void isWrong(String meaning) {
        if (meaning.equals("word")) {
            System.out.println("Введено некорректное название");
        } else if (meaning.equals("number")) {
            System.out.println("Введен некорректный номер");
        }
    }

}