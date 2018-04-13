package kz.colorsapp.sgq.colorsapp.mvp.presenter;

import android.util.Log;
import android.view.View;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.subscribers.DisposableSubscriber;
import kz.colorsapp.sgq.colorsapp.infraestructure.networking.gson.ColorsGson;
import kz.colorsapp.sgq.colorsapp.infraestructure.networking.gson.UpdateGson;
import kz.colorsapp.sgq.colorsapp.mvp.model.ColorsModelImpl;
import kz.colorsapp.sgq.colorsapp.mvp.model.interfaces.ColorsModel;
import kz.colorsapp.sgq.colorsapp.mvp.presenter.interfaces.ColorsPresenter;
import kz.colorsapp.sgq.colorsapp.mvp.view.ColorsView;
import kz.colorsapp.sgq.colorsapp.room.table.Colors;
import kz.colorsapp.sgq.colorsapp.ui.model.ConvertGson;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemColor;

public class ColorsPresenterImpl implements ColorsPresenter {

    private ColorsView view;
    private ColorsModel model;

    public ColorsPresenterImpl(ColorsView view) {
        this.view = view;
        model = new ColorsModelImpl();
        init();
    }

    private void init() {
        view.showLoadDB();
        model.getLocalService()
                .getColors()
                .subscribe(new DisposableMaybeObserver<List<Colors>>() {
                    @Override
                    public void onSuccess(List<Colors> colors) {
                        if (colors.size() == 0) {
                            getApiColors();
                            model.getApiService().insertUpdate();
                        } else {
                            handlerColorList(colors);
                            getApiCheck(colors);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });

        model.getLocalService()
                .getColors(true)
                .subscribe(new DisposableSubscriber<List<Colors>>() {
                    @Override
                    public void onNext(List<Colors> colors) {
                        if (colors.size() == 0) {
                            for (int i = 0; i < view.getColorList().size(); i++) {
                                if (view.getColorList().get(i).isLike())
                                    view.updateItemsDB(i);
                            }
                        } else {
                            for (int i = 0; i < view.getColorList().size(); i++) {
                                if (view.getColorList().get(i).isLike())
                                    if (isHandlerColor(i, colors))
                                        view.updateItemsDB(i);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    private void getApiCheck(List<Colors> colors) {
        model.getApiService()
                .updateCheck()
                .subscribe(new Observer<UpdateGson>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(UpdateGson updateGson) {
                        if (model.getCheck() < Integer.parseInt(updateGson.getCheck())) {
                            int check = Integer.parseInt(updateGson.getCheck());
                            model.getLocalService()
                                    .updateUpdate(model.getCheck(), check);
                            getUpdateColorList(model.getCheck());
                        } else {
                            handlerColorList(colors);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        handlerColorList(colors);
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    private void getUpdateColorList(int check) {
        model.getApiService()
                .updateColors(check)
                .subscribe(new Observer<List<ColorsGson>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("TestTAg", "onSubscribe");
                    }

                    @Override
                    public void onNext(List<ColorsGson> colorsGsons) {
                        Log.d("TestTAg", "onNext");
                        if (colorsGsons.size() != 0) {
                            model.getLocalService()
                                    .insertColors(ConvertGson
                                            .convertColorsList(colorsGsons));
                            view.addItemsDB(model
                                    .converterToItemColor(colorsGsons));
                            model.setRandomSize(colorsGsons.size());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TestTAg", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("TestTAg", "onComplete");
                    }
                });
    }

    private void handlerColorList(List<Colors> colors) {
        model.initRandom(colors.size());
        view.showColorList();
        getColorList();
        model.setLoading(false);
    }

    private boolean isHandlerColor(int index, List<Colors> colors) {
        for (int i = 0; i < colors.size(); i++) {
            if (view.getColorList().get(index).getId() ==
                    colors.get(i).getIdCol())
                return true;
        }
        return false;
    }

    private void getApiColors() {
        model.getApiService()
                .getAllColors()
                .subscribe(new Observer<List<ColorsGson>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<ColorsGson> colorsGsons) {
                        model.getLocalService().insertColors(ConvertGson
                                .convertColorsList(colorsGsons));
                        model.initRandom(colorsGsons.size());
                        view.showColorList();
                        getColorList();
                        model.setLoading(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public void handlerColorListner(int itemCount, int lastVisibleItem) {
        if (!model.isLoading() &&
                itemCount <= (lastVisibleItem + model.getVisibleThreshold())) {
            getColorList();
            model.setLoading(true);
        }
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

    private void getColorList() {
        model.getLocalService()
                .getColors(model.getNumbers())
                .subscribe(new DisposableMaybeObserver<List<Colors>>() {
                    @Override
                    public void onSuccess(List<Colors> colors) {
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
    }
}
