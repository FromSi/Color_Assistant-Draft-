package kz.colorsapp.sgq.colorsapp.mvp.presenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kz.colorsapp.sgq.colorsapp.infraestructure.networking.gson.ColorsGson;
import kz.colorsapp.sgq.colorsapp.mvp.model.ColorsModelImpl;
import kz.colorsapp.sgq.colorsapp.mvp.model.interfaces.ColorsModel;
import kz.colorsapp.sgq.colorsapp.mvp.presenter.interfaces.ColorsPresenter;
import kz.colorsapp.sgq.colorsapp.mvp.view.ColorsView;
import kz.colorsapp.sgq.colorsapp.room.table.Colors;
import kz.colorsapp.sgq.colorsapp.room.table.Update;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemColor;

public class ColorsPresenterImpl implements ColorsPresenter {

    private ColorsView view;
    private ColorsModel model;
    private CompositeDisposable compositeDisposable;

    public ColorsPresenterImpl(ColorsView view) {
        this.view = view;
        init();
        updateLocal();
    }

    private void init() {
        model = new ColorsModelImpl();
        compositeDisposable = new CompositeDisposable();
    }

    private void updateLocal() {
        Disposable disposable = model.getLocalService()
                .getUpdate()
                .subscribe(new Consumer<Update>() {
                    @Override
                    public void accept(Update update) throws Exception {
                        model.getApiService().updateColors(update.getCheck());
                    }
                });
        compositeDisposable.add(disposable);
    }

    @Override
    public void handlerColorListner(int itemCount, int lastVisibleItem) {
        if (!model.isLoading() &&
                itemCount <= (lastVisibleItem + model.getVisibleThreshold())) {
            model.addPageNumber();
            int[] arry = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
            model.getLocalService()
                    .getColors(arry)
                    .subscribe(new MaybeObserver<List<Colors>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onSuccess(List<Colors> colors) {
                            view.addItemsDB(model
                                    .getItemColor(colors));
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

    @Override
    public void downloadAllDB() {
        model.getApiService().getAllColors();
    }

    @Override
    public void uploadLastDB() {

    }
}
