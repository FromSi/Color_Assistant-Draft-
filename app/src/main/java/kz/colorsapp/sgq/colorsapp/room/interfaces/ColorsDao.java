package kz.colorsapp.sgq.colorsapp.room.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import kz.colorsapp.sgq.colorsapp.room.table.Colors;

/**
 * Таблица комбо цветов
 *
 * @see ColorsDao#insert(Colors) - Добавление записи
 * @see ColorsDao#update(int, boolean) - Изменить статус like
 * @see ColorsDao#getColors(int[]) - Возврат конкретных строк
 *
 * @author fromsi
 * @version 0.1
 */

@Dao
public interface ColorsDao {
    @Insert
    void insert(Colors colors);

    @Query("UPDATE `colors` SET `like`=:like WHERE `idCol`=:idCol")
    void update(int idCol, boolean like);

    @Query("SELECT * FROM `colors` WHERE `idCol` IN (:colorIds)")
    List<Colors> getColors(int[] colorIds);
}
