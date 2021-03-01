package ru.mephi.diti.it.dvsykeev.jsonio.data;

import java.util.ArrayList;
import java.util.List;

/**
 * День в недельном расписании WeekSchedule
 * items - список пар в расписании конкретной группы (StudentGroup > WeekSchedule)
 */
public class WeekScheduleDay implements JsonConvertable {
    List<String> items;

    public WeekScheduleDay(int pairCount) {
        items = new ArrayList<>();
        for (var i = 0; i < pairCount; ++i)
            items.add("");
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public String toJson() {
        // Запишем items в строку как массив строк
        return String.format("{\"items\": %s}", JsonUtils.stringListToJson(items));
    }
}
