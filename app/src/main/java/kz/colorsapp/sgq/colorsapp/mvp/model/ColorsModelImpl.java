package kz.colorsapp.sgq.colorsapp.mvp.model;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.FlowableSubscriber;
import io.reactivex.subscribers.DisposableSubscriber;
import kz.colorsapp.sgq.colorsapp.infraestructure.networking.gson.ColorsGson;
import kz.colorsapp.sgq.colorsapp.mvp.model.interfaces.ColorsModel;
import kz.colorsapp.sgq.colorsapp.room.table.Checking;
import kz.colorsapp.sgq.colorsapp.room.table.Colors;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemColor;
import kz.colorsapp.sgq.colorsapp.ui.model.BaseApi;
import kz.colorsapp.sgq.colorsapp.ui.model.BaseLocal;
import kz.colorsapp.sgq.colorsapp.ui.model.RandomItems;

/**
 * Model - паттерн MVP
 *
 * @author fromsi
 * @version 0.1
 * @see ColorsModel - Model
 * @see kz.colorsapp.sgq.colorsapp.mvp.view.ColorsView - View
 * @see kz.colorsapp.sgq.colorsapp.mvp.presenter.interfaces.ColorsPresenter - Presenter
 */

public class ColorsModelImpl implements ColorsModel {

    private int update = 1;
    private boolean loading = true;
    private RandomItems randomItems;

    private BaseApi api;
    private BaseLocal local;

    private final int VISIBLE_THRESHOLD = 1;

    public ColorsModelImpl() {
        local = new BaseLocal();
        api = new BaseApi(local);
        init();
    }

    private void init() {
        local.getUpdate()
                .subscribe(new DisposableSubscriber<Checking>() {
                    @Override
                    public void onNext(Checking checking) {
                        update = checking.getCheck();
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
    public void initRandom(int size) {
        randomItems = new RandomItems(size);
    }

    @Override
    public int[] getNumbers() {
        return randomItems.getNumbers();
    }

    @Override
    public int getCheck() {
        return update;
    }

    @Override
    public List<ItemColor> getItemColor(List<Colors> colors) {
        List<ItemColor> list = new ArrayList<>();

        for (int i = 0; i < colors.size(); i++) {
            List<String> stringList = new ArrayList<>();
            stringList.add(colors.get(i).getColOne());
            stringList.add(colors.get(i).getColTwo());
            stringList.add(colors.get(i).getColThree());

            if (colors.get(i).getColFour() != null)
                stringList.add(colors.get(i).getColFour());

            if (colors.get(i).getColFive() != null)
                stringList.add(colors.get(i).getColFive());

            list.add(new ItemColor(colors.get(i).getIdCol(),
                    stringList, colors.get(i).isLike()));
        }
        return list;
    }

    @Override
    public BaseApi getApiService() {
        return api;
    }

    @Override
    public BaseLocal getLocalService() {
        return local;
    }

    @Override
    public boolean isLoading() {
        return loading;
    }

    @Override
    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    @Override
    public void setRandomSize(int size) {
        randomItems.resize(size);
    }

    @Override
    public int getVisibleThreshold() {
        return VISIBLE_THRESHOLD;
    }

    @Override
    public List<ItemColor> converterToItemColor(List<ColorsGson> list) {
        List<ItemColor> itemColorList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<String> stringList = new ArrayList<>();
            stringList.add(list.get(i).getCol1());
            stringList.add(list.get(i).getCol2());
            stringList.add(list.get(i).getCol3());

            if (list.get(i).getCol4() != null)
                stringList.add(list.get(i).getCol4());

            if (list.get(i).getCol5() != null)
                stringList.add(list.get(i).getCol5());

            ItemColor itemColor = new ItemColor(Integer
                    .parseInt(list.get(i).getIdCol()),
                    stringList, false);
            itemColorList.add(itemColor);
        }
        return itemColorList;
    }
}
