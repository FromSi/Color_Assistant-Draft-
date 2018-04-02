package kz.colorsapp.sgq.colorsapp.infraestructure.networking.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Парсинг таблицы с БД на сервере.
 * Проверка последнего обновления
 * локальной таблицы.
 *
 * @see UpdateGson#check - Последнее версия обновления
 *
 * @author fromsi
 * @version 0.1
 */

public class UpdateGson {

    @SerializedName("check")
    @Expose
    private String check;

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

}
