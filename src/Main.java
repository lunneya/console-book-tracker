import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Создание scanner для прочтения данных, что вводит пользователь
        Scanner scanner = new Scanner(System.in);
        // Создание объекта, который хранит список Item из ItemService.java
        ItemService service = new ItemService();

        // Временные данные для тестов
        // Добавление item в service
        service.addItem("Наруто", "Манга", 9);
        service.addItem("Волчица и пряности", "Манга", 10);
        service.addItem("Преступление и наказание", "Книга", 8);

        while (true) {
            System.out.println("\n1. Добавить запись");
            System.out.println("2. Удалить запись");
            System.out.println("3. Редактировать запись");
            System.out.println("4. Показать все записи");
            System.out.println("5. Поиск записи");
            System.out.println("0. Выход из программы");
            System.out.print("Выбор действия: ");

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

                    service.addItem(title, type, rating);
                    System.out.println("Запись добавлена");
                    break;

                case 2:
                    System.out.println("Введите ID для удаления");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    service.deleteItem(id);
                    break;

                case 3:
                    System.out.println("Введите ID записи для ее редактирования:");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Введите новое название:");
                    String newTitle = scanner.nextLine();

                    System.out.println("Введите новый тип:");
                    String newType = scanner.nextLine();

                    System.out.println("Введите новый рейтинг:");
                    int newRating = scanner.nextInt();
                    scanner.nextLine();

                    boolean updated = service.updateItem(id, newTitle, newType, newRating);

                    if (updated) {
                        System.out.println("Запись обновлена");
                    } else {
                        System.out.println("ID не найден");
                    }

                case 4:
                    // Получаю список, причем копию
                    List<Item> allItems = service.getAllItems();

                    // Для каждого элемента списка allItems, беру Item и кладу в currentItem, вывожу через геттеры
                    printItems(allItems);
                    break;

                case 5:
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
            System.out.printf("Id: %d%n, Название: %s, Тип: %s, Рейтинг: %d%n",
                    currentItem.getId(), currentItem.getTitle(), currentItem.getType(), currentItem.getRating()
            );
        }
    }
}
