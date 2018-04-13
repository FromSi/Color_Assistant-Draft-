package kz.colorsapp.sgq.colorsapp.mvp.presenter;

import android.util.Log;
import android.view.View;

import java.util.List;

import io.reactivex.subscribers.DisposableSubscriber;
import kz.colorsapp.sgq.colorsapp.mvp.model.ColorsModelImpl;
import kz.colorsapp.sgq.colorsapp.mvp.model.LikesModelImpl;
import kz.colorsapp.sgq.colorsapp.mvp.model.interfaces.ColorsModel;
import kz.colorsapp.sgq.colorsapp.mvp.model.interfaces.LikesModel;
import kz.colorsapp.sgq.colorsapp.mvp.presenter.interfaces.ColorsPresenter;
import kz.colorsapp.sgq.colorsapp.mvp.view.ColorsView;
import kz.colorsapp.sgq.colorsapp.room.table.Colors;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemColor;

public class LikesPresenterImpl implements ColorsPresenter {

    private ColorsView view;
    private LikesModel model;

    public LikesPresenterImpl(ColorsView view) {
        this.view = view;
        model = new LikesModelImpl();
        init();
    }

    private void init() {
        view.showLoadDB();
        model.getLocalService()
                .getColors(true)
                .subscribe(new DisposableSubscriber<List<Colors>>() {
                    @Override
                    public void onNext(List<Colors> colors) {
                        if (colors.size() == 0) {
                            view.clearItemsDB();
                            view.showLoadDB();
                        } else {
                            view.clearItemsDB();
                            view.addItemsDB(model
                                    .getItemColor(colors));
                            view.showColorList();
                        }

                        Log.d("LikeUpdate", "Like: list size - " + colors.size());

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void handlerColorListner(int itemCount, int lastVisibleItem) {

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

}
