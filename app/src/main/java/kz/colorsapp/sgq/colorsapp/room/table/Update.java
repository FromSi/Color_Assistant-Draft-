package kz.colorsapp.sgq.colorsapp.room.table;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Таблица последнего обновления
 * локальной базы данных.
 *
 * @see Update#check - Последнее обновление локальной базы данных
 *
 * @author fromsi
 * @version 0.1
 */

@Entity
public class Update {
    @PrimaryKey
    private int check;

    public Update(int check) {
        this.check = check;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
}
