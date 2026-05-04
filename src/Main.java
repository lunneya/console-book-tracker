import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        // Создание сканнера для прочтение данных, что вводит пользователь
        Scanner scanner = new Scanner(System.in);

        // Читаем введенные данные
        System.out.println("Название:");
        String title = scanner.nextLine();
        System.out.println("Тип:");
        String type = scanner.nextLine();
        System.out.println("Рейтинг:");
        int rating = scanner.nextInt();
        scanner.nextLine();

        ItemService service = new ItemService();
        Item item = new Item(title, type, rating);
        service.addItem(item);

        List<Item> allItems = service.getAllItems();
        for (Item currentItem : allItems) {
            System.out.printf("Title: %s, Type: %s, Rating: %d%n",
                    currentItem.getTitle(), currentItem.getType(), currentItem.getRating()
            );
        }
    }
}
