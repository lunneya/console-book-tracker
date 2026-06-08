import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Создание scanner для прочтения данных, что вводит пользователь
        Scanner scanner = new Scanner(System.in);
        // Создание объекта, который хранит список Item из ItemService.java
        RepertoireService service = new RepertoireService();

        // Временные данные для тестов
        // Добавление item в service
        service.addItem("Bilewater","Christopher Larkin", "Piano", "GAME_SOUNDTRACK", 10);

        // Тестовый вызов метода для сохранения
        FileService fileService = new FileService();
//        fileService.saveTest();
//        fileService.loadTest();
        fileService.saveOneItemTest();
        fileService.loadOneItemTest();

        while (true) {
            System.out.println("\n\n=== Репертуар музыканта ===\n");
            System.out.println("1. Добавить произведение");
            System.out.println("2. Удалить произведение");
            System.out.println("3. Редактировать произведение");
            System.out.println("4. Сортировать произведения");
            System.out.println("5. Показать репертуар");
            System.out.println("6. Поиск произведения");
            System.out.println("0. Выход");
            System.out.print("\nВыбор действия: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Читаем введенные данные
                    System.out.println("Название:");
                    String title = scanner.nextLine();

                    System.out.println("Композитор:");
                    String composer = scanner.nextLine();

                    System.out.println("Инструмент:");
                    String instrument = scanner.nextLine();

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

                    service.addItem(title, composer, instrument, type, rating);
                    System.out.println("Запись добавлена");
                    break;

                case 2:
                    System.out.println("Введите ID для удаления записи");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    RepertoireItem foundItem = service.findById(id);

                    if (foundItem != null) {
                        System.out.printf("Удалена запись: %s", foundItem.getTitle());
                        service.deleteItem(id);
                    } else {
                        System.out.println("Запись не найдена");
                    }
                    break;

                case 3:
                    System.out.println("Введите ID записи для ее редактирования:");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Введите новое название:");
                    String newTitle = scanner.nextLine();

                    System.out.println("Введите нового композитора:");
                    String newComposer = scanner.nextLine();

                    System.out.println("Введите новый инструмент:");
                    String newInstrument = scanner.nextLine();

                    System.out.println("Введите новый тип:");
                    String newType = scanner.nextLine();

                    System.out.println("Введите новый рейтинг:");
                    int newRating = scanner.nextInt();
                    scanner.nextLine();

                    boolean updated = service.updateItem(id, newTitle, newComposer, newInstrument, newType, newRating);

                    if (updated) {
                        System.out.println("Запись обновлена");
                    } else {
                        System.out.println("ID не найден");
                    }
                    break;

                case 4:
                    List<RepertoireItem> sortedItems = service.sortByRating();
                    printItems(sortedItems);
                    break;

                case 5:
                    // Получаю список, причем копию
                    List<RepertoireItem> allRepertoireItems = service.getAllItems();

                    // Для каждого элемента списка allItems, беру Item и кладу в currentItem, вывожу через геттеры
                    printItems(allRepertoireItems);
                    break;

                case 6:
                    boolean searchMenuRunning = true;
                    while (searchMenuRunning) {
                        System.out.println("\n1. По названию");
                        System.out.println("2. По композитору");
                        System.out.println("3. По инструменту");
                        System.out.println("4. По типу");
                        System.out.println("5. По рейтингу");
                        System.out.println("0. Вернутся в меню");
                        System.out.print("Выбор: \n");

                        int searchMenuChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (searchMenuChoice) {
                            case 1:
                                System.out.println("Введите название:");
                                String searchTitle = scanner.nextLine();

                                List<RepertoireItem> foundByTitle = service.findByTitle(searchTitle);
                                if (foundByTitle.isEmpty()) {
                                    System.out.println("Совпадений не найдено");
                                } else {
                                    printItems(foundByTitle);
                                }
                                break;

                            case 2:
                                System.out.println("Введите композитора:");
                                String searchComposer = scanner.nextLine();

                                List<RepertoireItem> foundByComposer = service.findByComposer(searchComposer);
                                if (foundByComposer.isEmpty()) {
                                    System.out.println("Совпадений не найдено");
                                } else {
                                    printItems(foundByComposer);
                                }
                                break;

                            case 3:
                                System.out.println("Введите инструмент:");
                                String searchInstrument = scanner.nextLine();

                                List<RepertoireItem> foundByInstrument = service.findByInstrument(searchInstrument);
                                if (foundByInstrument.isEmpty()) {
                                    System.out.println("Совпадений не найдено");
                                } else {
                                    printItems(foundByInstrument);
                                }
                                break;

                            case 4:
                                System.out.println("Введите тип:");
                                String searchType = scanner.nextLine();

                                List<RepertoireItem> foundByType = service.findByType(searchType);

                                if (foundByType.isEmpty()) {
                                    System.out.println("Совпадений не найдено");
                                } else {
                                    printItems(foundByType);
                                }
                                break;

                            case 5:
                                System.out.println("Введите рейтинг (от 1 до 10)");
                                int searchRating = scanner.nextInt();
                                scanner.nextLine();

                                List<RepertoireItem> foundByRating = service.findByRating(searchRating);
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
    public static void printItems(List<RepertoireItem> items) {
        for (RepertoireItem currentItem : items) {
            System.out.printf("[%d] | %s | %s | %s | %s | %d%n",
                    currentItem.getId(),
                    currentItem.getTitle(),
                    currentItem.getComposer(),
                    currentItem.getInstrument(),
                    currentItem.getType(),
                    currentItem.getRating()
            );
        }
    }
}
