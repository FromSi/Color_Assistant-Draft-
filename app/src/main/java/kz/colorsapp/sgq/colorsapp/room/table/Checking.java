package kz.colorsapp.sgq.colorsapp.room.table;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Таблица последнего обновления локальной БД
 *
 * @see Checking#check - (in next commit)
 */

@Entity
public class Checking {
    @PrimaryKey
    private int check;

    public Checking(int check) {
        this.check = check;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
}
