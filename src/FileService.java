import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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

    public void save() {

    }

    public void load() {

    }
}
