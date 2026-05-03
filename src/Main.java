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

        // Создаем класс для вывода данных
        Item items = new Item(title, type, rating);

        // Вывод данных
        System.out.printf("Title: %s, Type: %s, Rating: %d%n", items.getTitle(), items.getType(), items.getRating());
    }
}
