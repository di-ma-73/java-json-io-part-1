package ru.mephi.diti.it.dvsykeev.jsonio.data;

import java.util.List;

public class JsonUtils {
    public static String stringListToJson(List<String> items) {
        var itemsBuffer = new StringBuilder();
        int idx = 0;
        for (var item : items) {
            itemsBuffer.append(String.format("\"%s\"", item));
            if (idx != items.size() - 1) {
                itemsBuffer.append(", ");
            }
            ++idx;
        }
        return String.format("[%s]", itemsBuffer);
    }
}
