package kz.colorsapp.sgq.colorsapp.ui.model;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kz.colorsapp.sgq.colorsapp.application.App;
import kz.colorsapp.sgq.colorsapp.room.AppDatabase;
import kz.colorsapp.sgq.colorsapp.room.table.Checking;
import kz.colorsapp.sgq.colorsapp.room.table.Colors;

public class BaseLocal {
    private AppDatabase database;

    public BaseLocal() {
        database = App.getInstance().getDatabase();
    }

    public void insertColors(List<Colors> colors){
        database.colorsDao().insert(colors);
    }

    public void insertUpdate(Checking update){
        database.updateDao().insert(update);
    }

    public void updateColors(int idCol, boolean like){
        database.colorsDao().update(idCol, like);
    }

    public void updateUpdate(int first, int last){
        database.updateDao().update(first, last);
    }

    public Maybe<List<Colors>> getColors(int[] colorIds){
        return database.colorsDao()
                .getColors(colorIds)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Flowable<List<Colors>> getColor(){
        return database.colorsDao()
                .getColor()
                .observeOn(AndroidSchedulers.mainThread());
    }
}
