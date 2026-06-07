import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileService {

    public void saveTest() {
        Path path = Path.of("repertoire.txt");

        try {
            Files.writeString(path, "Привет, файл работает!");
            System.out.println("Файл успешно сохранен");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении файла");
        }
    }


    public void loadTest() {
        Path path = Path.of("repertoire.txt");
        try {
            String text = Files.readString(path);
            System.out.println(text);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
        }
    }

    public void save() {

    }

    public void load() {

    }
}
