package ru.mephi.diti.it.dvsykeev.jsonio.data;

/**
 * Учебная группа студентов
 * и поле с их расписанием
 */
public class StudentGroup implements JsonConvertable {
    private final String name;
    WeekSchedule firstWeek;
    WeekSchedule secondWeek;

    public StudentGroup(String name) {
        this.name = name;
        this.firstWeek = new WeekSchedule(6);
        this.secondWeek = new WeekSchedule(6);
    }

    public WeekSchedule getFirstWeek() {
        return firstWeek;
    }

    public WeekSchedule getSecondWeek() {
        return secondWeek;
    }

    @Override
    public String toJson() {
        return String.format("{\"name\": \"%s\", \"firstWeek\": %s, \"secondWeek\": %s}", name, firstWeek.toJson(), secondWeek.toJson());
    }
}
