import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileService {

    public void saveTest() {
        Path path = Path.of("repertoire.txt");

        try {
            Files.writeString(path, "Файл");
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

    public void saveOneItemTest() {

        RepertoireItem item = new RepertoireItem(
                1,
                "Bilewater",
                "Christopher Larkin",
                "Piano",
                "GAME_SOUNDTRACK",
                10
        );

        String line = String.format("%d;%s;%s;%s;%s;%d",
                item.getId(),
                item.getTitle(),
                item.getComposer(),
                item.getInstrument(),
                item.getType(),
                item.getRating()
        );
        Path path = Path.of("repertoireTest.txt");

        try {
            Files.writeString(path, line);
            System.out.println("Файл записан");

        } catch (IOException e) {
            System.out.println("Ошибка");
        }
    }

    public void loadOneItemTest() {
        String line = "";
        Path path = Path.of("repertoireTest.txt");
        try {
            line = Files.readString(path);
        } catch (IOException e) {
            System.out.println("Ошибка");
        }

        String[] parts = line.split(";");

        RepertoireItem item = new RepertoireItem(
                Integer.parseInt(parts[0]),
                parts[1],
                parts[2],
                parts[3],
                parts[4],
                Integer.parseInt(parts[5])
        );
        System.out.println(item);

    }

    public void save() {

    }

    public void load() {

    }
}
