package kz.colorsapp.sgq.colorsapp.mvp.presenter;

import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.List;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kz.colorsapp.sgq.colorsapp.mvp.model.ColorsModelImpl;
import kz.colorsapp.sgq.colorsapp.mvp.model.interfaces.ColorsModel;
import kz.colorsapp.sgq.colorsapp.mvp.presenter.interfaces.ColorsPresenter;
import kz.colorsapp.sgq.colorsapp.mvp.view.ColorsView;
import kz.colorsapp.sgq.colorsapp.room.table.Colors;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemColor;

/**
 * Presenter - паттерн MVP
 * @see ColorsModel - Model
 * @see ColorsView - View
 * @see ColorsPresenter - Presenter
 *
 * @author fromsi
 * @version 0.1
 */

public class ColorsPresenterImpl implements ColorsPresenter {

    private ColorsView view;
    private ColorsModel model;
    private CompositeDisposable compositeDisposable;

    public ColorsPresenterImpl(ColorsView view) {
        this.view = view;
        init();
        getColor();
    }

    private void init() {
        model = new ColorsModelImpl();
        compositeDisposable = new CompositeDisposable();
        view.showDownloadDB();
    }

    private void getColor() {
        Disposable disposable = model.getLocalService()
                .getColor()
                .subscribe(new Consumer<List<Colors>>() {
                    @Override
                    public void accept(List<Colors> colors) throws Exception {
                        if (colors.size() != 0){
                            model.initRandom(colors.size());
                            model.getApiService().insertUpdate();
                            view.showColorList();
                            addList();
                        }
                    }
                });
        compositeDisposable.add(disposable);
    }

    @Override
    public void handlerColorListner(int itemCount, int lastVisibleItem) {
        Log.d(this.getClass().getName(), "handler on");
        if (!model.isLoading() &&
                itemCount <= (lastVisibleItem + model.getVisibleThreshold())) {
            Log.d(this.getClass().getName(), "if on");
            addList();
        }
    }

    @Override
    public void downloadAllDB() {
        model.getApiService().getAllColors();
    }

    @Override
    public void uploadLastDB() {

    }

    @Override
    public void onItemLikeClick(View view, int id, boolean like) {
        model.getLocalService()
                .updateColors(id, like);
    }

    @Override
    public void onItemViewClick(View view, ItemColor itemColor) {
        this.view.showActivityInfo(itemColor.getColors());
    }

    private void addList() {
        model.addPageNumber();
        model.getLocalService()
                .getColors(model.getNumbers())
                .subscribe(new MaybeObserver<List<Colors>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Colors> colors) {
                        Log.d(this.getClass().getName(), "handler view");
                        view.addItemsDB(model
                                .getItemColor(colors));
                        model.setLoading(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        model.setLoading(true);
    }
}
