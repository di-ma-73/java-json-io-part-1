package ru.mephi.diti.it.dvsykeev.jsonio.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Расписание учебной группы на неделю по дням
 */
public class WeekSchedule implements JsonConvertable {
    List<WeekScheduleDay> days;

    public WeekSchedule(int dayCount) {
        days = new ArrayList<>();
        for (var i = 0; i < dayCount; ++i)
            days.add(new WeekScheduleDay(6));
    }

    public WeekScheduleDay getDayByName(WeekScheduleDayName dayName) {
        return days.get(dayName.ordinal());
    }

    @Override
    public String toJson() {
        var daysBuffer = new StringBuilder();
        int idx = 0;
        for (var d : days) {
            daysBuffer.append(d.toJson());
            if (idx != days.size() - 1) {
                daysBuffer.append(", ");
            }
            ++idx;
        }
        return String.format("[%s]", daysBuffer);
    }
}
