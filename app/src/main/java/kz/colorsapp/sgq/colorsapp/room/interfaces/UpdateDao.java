package kz.colorsapp.sgq.colorsapp.room.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import kz.colorsapp.sgq.colorsapp.room.table.Update;

/**
 * Таблица последнего обновления
 * локальной базы данных.
 *
 * @see UpdateDao#insert(Update)  - Добавление записи
 * @see UpdateDao#getUpdate()  - Последнее обновление локальной БД
 * @see UpdateDao#update(int, int)  - Изменение последнего обновления БД
 *
 * @author fromsi
 * @version 0.1
 */

@Dao
public interface UpdateDao {
    @Insert
    void insert(Update update);

    @Query("SELECT * FROM `update`")
    Update getUpdate();

    @Query("UPDATE `update` SET `check`=:check WHERE `check`=:update")
    void update(int check, int update);
}
