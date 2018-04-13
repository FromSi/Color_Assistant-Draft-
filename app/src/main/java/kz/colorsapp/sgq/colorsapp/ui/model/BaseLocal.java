package kz.colorsapp.sgq.colorsapp.ui.model;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
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

    public void insertColors(List<Colors> colors) {
        Completable.fromAction(() -> database.colorsDao().insert(colors))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public void insertUpdate(Checking update) {
        database.updateDao().insert(update);
    }

    public void updateColors(int idCol, boolean like) {
        Completable.fromAction(() -> database.colorsDao().update(idCol, like))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public void updateUpdate(int first, int last) {
        Completable.fromAction(() -> database.updateDao().update(first, last))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }


    public Maybe<List<Colors>> getColors(int[] colorIds) {
        return database.colorsDao()
                .getColors(colorIds)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Maybe<List<Colors>> getColors() {
        return database.colorsDao()
                .getColors()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Flowable<List<Colors>> getColors(boolean like){
        return database.colorsDao()
                .getColors(like)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Flowable<Checking> getUpdate(){
        return database.updateDao()
                .getCheck()
                .subscribeOn(Schedulers.io());
    }
}
