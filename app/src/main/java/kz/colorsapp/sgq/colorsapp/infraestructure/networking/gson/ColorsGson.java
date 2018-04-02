package kz.colorsapp.sgq.colorsapp.infraestructure.networking.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Парсинг таблицы с БД на сервере.
 * Комбо цвета.
 *
 * @see ColorsGson#col1 - Первый цвет
 * @see ColorsGson#col1 - Второй цвет
 * @see ColorsGson#col1 - Третий цвет
 * @see ColorsGson#col1 - Четвертый цвет [Иногда принимает null]
 * @see ColorsGson#col1 - Пятый цвет [Иногда принимает null]
 *
 * @see ColorsGson#idCol - Идентификатор таблицы
 * @see ColorsGson#check - Последнее обновление цвета на сервере
 *
 * @author fromsi
 * @version 0.1
 */

public class ColorsGson {
    @SerializedName("col_5")
    @Expose
    private String col5;
    @SerializedName("col_4")
    @Expose
    private String col4;
    @SerializedName("col_3")
    @Expose
    private String col3;
    @SerializedName("col_2")
    @Expose
    private String col2;
    @SerializedName("col_1")
    @Expose
    private String col1;
    @SerializedName("id_col")
    @Expose
    private String idCol;
    @SerializedName("check")
    @Expose
    private String check;

    public String getCol5() {
        return col5;
    }

    public void setCol5(String col5) {
        this.col5 = col5;
    }

    public String getCol4() {
        return col4;
    }

    public void setCol4(String col4) {
        this.col4 = col4;
    }

    public String getCol3() {
        return col3;
    }

    public void setCol3(String col3) {
        this.col3 = col3;
    }

    public String getCol2() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2 = col2;
    }

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    public String getIdCol() {
        return idCol;
    }

    public void setIdCol(String idCol) {
        this.idCol = idCol;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

}
