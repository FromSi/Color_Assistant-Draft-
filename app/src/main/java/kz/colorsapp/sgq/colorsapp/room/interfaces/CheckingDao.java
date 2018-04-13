package kz.colorsapp.sgq.colorsapp.room.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import kz.colorsapp.sgq.colorsapp.room.table.Checking;

/**
 * Таблица последнего обновления
 * локальной базы данных.
 *
 * @see CheckingDao#insert(Checking) - Добавление записи
 * @see CheckingDao#getCheck() - Последнее обновление локальной БД
 * @see CheckingDao#update(int, int) - Изменение последнего обновления БД
 *
 * @author fromsi
 * @version 0.2
 */

@Dao
public interface CheckingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Checking checking);

    @Query("SELECT * FROM `checking`")
    Flowable<Checking> getCheck();

    @Query("UPDATE `checking` SET `check`=:last WHERE `check`=:first")
    void update(int first, int last);
}
