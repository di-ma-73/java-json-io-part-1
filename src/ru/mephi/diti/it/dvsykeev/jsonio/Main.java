package ru.mephi.diti.it.dvsykeev.jsonio;

import ru.mephi.diti.it.dvsykeev.jsonio.data.StudentGroup;
import ru.mephi.diti.it.dvsykeev.jsonio.data.WeekScheduleDayName;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

// JSON - распространённый текстовый формат данных, т.е. символьный.
// Объект представляется как набор пар "свойство": "значение" внутри скобок { }
// (также называют как "ключ": "значение")
// Объекты могут быть объединены в массив, если записать через запятую в скобках [{...}, {...}, ..., {...}]
// Ключом может быть практически любая строка, даже с пробелами, но так делать не рекомендуется.
// Значением свойства (ключа) может быть другой объект или даже массив.
// Массив может содержать и простые значения, например, [1, 2, 3] или ["Ксения", "Наталья", "Владислав", "Илья", "Тимур"]
// .. и даже, как во многих языках программирования, другие массивы [[1, 2, 3], [4, 5, 6], ["А", "Б", "В"]]
public class Main {
    // Будет использовать файл на рабочем столе Windows с названием <название пакета программы>.json
    public static final Path dbFilePath = Path.of(System.getenv("USERPROFILE"), "Desktop", Main.class.getPackageName() + ".json");

    public static void main(String[] args) {
        var group1 = new StudentGroup("ВТ-41");
        var group2 = new StudentGroup("ИСТ-41");

        // Добавим ИСТ-41 3 пару во вторник на первой неделе
        group2.getFirstWeek()
                .getDayByName(WeekScheduleDayName.Tuesday)
                .getItems().set(3 - 1, "Введение в Java-технологии");

        List<StudentGroup> groups = new ArrayList<>();
        groups.add(group1);
        groups.add(group2);

        System.out.printf("✅ Группы добавлены в список [%d шт.]%n", groups.size());

        System.out.printf("🔶 Сохраняем данные в JSON-файл [%s]%n", dbFilePath);
        var buffer = new StringBuilder();
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(dbFilePath.toFile(), false))) {
            int idx = 0;
            for (var g : groups) {
                buffer.append(g.toJson());
                if (idx != groups.size() - 1) {
                    buffer.append(", ");
                }
                ++idx;
            }
            writer.write(String.format("[%s]", buffer));
            System.out.printf("✅ Группы успешно записаны в файл в формате JSON%n");
        } catch (FileNotFoundException e) {
            System.out.println("❗ Ошибка записи в файл: файл не найден или не удалось открыть по данному пути");
            System.out.printf("❗ %s: [%s]%n", e.getMessage(), dbFilePath);
        } catch (IOException e) {
            System.out.println("❗ Ошибка записи в файл: непредвиденная ошибка записи в файл");
            System.out.printf("❗ %s: [%s]%n", e.getMessage(), dbFilePath);
        }
    }
}
