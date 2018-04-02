package kz.colorsapp.sgq.colorsapp.room.table;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Таблица комбо цветов
 *
 * @see Colors#colOne - Первый цвет
 * @see Colors#colTwo - Второй цвет
 * @see Colors#colThree - Третий цвет
 * @see Colors#colFour - Четвертый цвет
 * @see Colors#colFive - Пятый цвет
 *
 * @see Colors#idCol - Идентификатор
 * @see Colors#like - Статус записи
 *
 * @author fromsi
 * @version 0.1
 */

@Entity
public class Colors {
    @PrimaryKey
    private int idCol;
    private String colOne;
    private String colTwo;
    private String colThree;
    private String colFour;
    private String colFive;
    private boolean like;

    public Colors(int idCol, String colOne, String colTwo, String colThree, String colFour, String colFive, boolean like) {
        this.idCol = idCol;
        this.colOne = colOne;
        this.colTwo = colTwo;
        this.colThree = colThree;
        this.colFour = colFour;
        this.colFive = colFive;
        this.like = like;
    }

    public int getIdCol() {
        return idCol;
    }

    public void setIdCol(int idCol) {
        this.idCol = idCol;
    }

    public String getColOne() {
        return colOne;
    }

    public void setColOne(String colOne) {
        this.colOne = colOne;
    }

    public String getColTwo() {
        return colTwo;
    }

    public void setColTwo(String colTwo) {
        this.colTwo = colTwo;
    }

    public String getColThree() {
        return colThree;
    }

    public void setColThree(String colThree) {
        this.colThree = colThree;
    }

    public String getColFour() {
        return colFour;
    }

    public void setColFour(String colFour) {
        this.colFour = colFour;
    }

    public String getColFive() {
        return colFive;
    }

    public void setColFive(String colFive) {
        this.colFive = colFive;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
