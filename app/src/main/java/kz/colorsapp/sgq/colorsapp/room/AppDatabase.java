package kz.colorsapp.sgq.colorsapp.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import kz.colorsapp.sgq.colorsapp.room.interfaces.ColorsDao;
import kz.colorsapp.sgq.colorsapp.room.interfaces.UpdateDao;
import kz.colorsapp.sgq.colorsapp.room.table.Colors;
import kz.colorsapp.sgq.colorsapp.room.table.Update;

/**
 * Локальная база данных android
 *
 * @see AppDatabase#colorsDao() - Таблица комбо цветов
 * @see AppDatabase#updateDao() - Таблица последнего обновления
 *
 * @author fromsi
 * @version 0.1
 */

@Database(entities = {Colors.class, Update.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ColorsDao colorsDao();

    public abstract UpdateDao updateDao();
}
