package kz.colorsapp.sgq.colorsapp.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import kz.colorsapp.sgq.colorsapp.room.interfaces.CheckingDao;
import kz.colorsapp.sgq.colorsapp.room.interfaces.ColorsDao;
import kz.colorsapp.sgq.colorsapp.room.table.Checking;
import kz.colorsapp.sgq.colorsapp.room.table.Colors;

/**
 * Локальная база данных android
 *
 * @see AppDatabase#colorsDao() - Таблица комбо цветов
 * @see AppDatabase#updateDao() - Таблица последнего обновления
 *
 * @author fromsi
 * @version 0.1
 */

@Database(entities = {Colors.class, Checking.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ColorsDao colorsDao();

    public abstract CheckingDao updateDao();
}
