package kz.colorsapp.sgq.colorsapp.ui.model;

import java.util.List;

public class ItemDetails {
    String value;
    Integer color;

    public ItemDetails(String value, Integer color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public Integer getColor() {
        return color;
    }
}
