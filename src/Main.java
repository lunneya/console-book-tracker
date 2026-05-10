import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Создание scanner для прочтения данных, что вводит пользователь
        Scanner scanner = new Scanner(System.in);
        // Создание объекта, который хранит список Item из ItemService.java
        ItemService service = new ItemService();

        // Временные данные для тестов
        Item item1 = new Item("Наруто", "Манга", 9);
        Item item2 = new Item("Волчица и пряности", "Манга", 10);
        Item item3 = new Item("Преступление и наказание", "Книга", 8);
        // Добавление item в service
        service.addItem(item1);
        service.addItem(item2);
        service.addItem(item3);

        while (true) {
            System.out.println("\n1. Добавить");
            System.out.println("2. Показать все");
            System.out.println("3. Поиск");
            System.out.println("0. Выход");
            System.out.print("Выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Читаем введенные данные
                    System.out.println("Название:");
                    String title = scanner.nextLine();

                    System.out.println("Тип:");
                    String type = scanner.nextLine();

                    // Проверка через цикл на диапазон
                    int rating;
                    while (true) {
                        System.out.println("Рейтинг (1-10):");
                        rating = scanner.nextInt();
                        scanner.nextLine();

                        if (rating >= 1 && rating <= 10) {
                            break;
                        } else {
                            System.out.println("Число должно быть от 1 до 10");
                        }
                    }

                    // Создание объекта Item, беру введенные данные и создаю одну запись
                    Item item = new Item(title, type, rating);
                    // Вызываю метод и кладу item в список
                    service.addItem(item);
                    System.out.println("Запись добавлена");
                    break;

                case 2:
                    // Получаю список, причем копию
                    List<Item> allItems = service.getAllItems();

                    // Для каждого элемента списка allItems, беру Item и кладу в currentItem, вывожу через геттеры
                    printItems(allItems);
                    break;

                case 3:
                    boolean searchMenuRunning = true;
                    while (searchMenuRunning) {
                        System.out.println("\n1. По названию");
                        System.out.println("2. По типу");
                        System.out.println("3. По рейтингу");
                        System.out.println("0. Вернутся в меню");
                        System.out.print("Выбор: \n");

                        int searchMenuChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (searchMenuChoice) {
                            case 1:
                                System.out.println("Введите название:");
                                String searchTitle = scanner.nextLine();

                                List<Item> foundByTitle = service.findByTitle(searchTitle);
                                if (foundByTitle.isEmpty()) {
                                    System.out.println("Совпадений не найдено");
                                } else {
                                    printItems(foundByTitle);
                                }
                                break;

                            case 2:
                                System.out.println("Введите тип:");
                                String searchType = scanner.nextLine();

                                List<Item> foundByType = service.findByType(searchType);

                                if (foundByType.isEmpty()) {
                                    System.out.println("Совпадений не найдено");
                                } else {
                                    printItems(foundByType);
                                }
                                break;

                            case 3:
                                System.out.println("Введите рейтинг (от 1 до 10)");
                                int searchRating = scanner.nextInt();
                                scanner.nextLine();

                                List<Item> foundByRating = service.findByRating(searchRating);
                                if (foundByRating.isEmpty()) {
                                    System.out.println("Совпадений не найдено");
                                } else {
                                  printItems(foundByRating);
                                }
                                break;

                            case 0:
                                System.out.println("Выход...");
                                searchMenuRunning = false;
                                break;

                            default:
                                System.out.println("Неверный выбор");
                        }
                    }
                    break;


                case 0:
                    System.out.println("Выход...");
                    return;

                default:
                    System.out.println("Неверный выбор");
            }
        }
    }

    // Создание метода для вывода на печать данных
    // Для каждого элемента списка items, беру Item и кладу в currentItem, вывожу через геттеры
    public static void printItems(List<Item> items) {
        for (Item currentItem : items) {
            System.out.printf("Название: %s, Тип: %s, Рейтинг: %d%n",
                    currentItem.getTitle(), currentItem.getType(), currentItem.getRating()
            );
        }
    }
}
