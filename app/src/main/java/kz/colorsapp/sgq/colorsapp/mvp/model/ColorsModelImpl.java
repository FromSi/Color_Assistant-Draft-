package kz.colorsapp.sgq.colorsapp.mvp.model;

import java.util.ArrayList;
import java.util.List;

import kz.colorsapp.sgq.colorsapp.mvp.model.base.ColorsModelBase;
import kz.colorsapp.sgq.colorsapp.mvp.model.interfaces.ColorsModel;
import kz.colorsapp.sgq.colorsapp.room.table.Colors;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemColor;
import kz.colorsapp.sgq.colorsapp.ui.model.BaseApi;
import kz.colorsapp.sgq.colorsapp.ui.model.BaseLocal;
import kz.colorsapp.sgq.colorsapp.ui.model.RandomItems;

/**
 * Model - паттерн MVP
 * @see ColorsModel - Model
 * @see kz.colorsapp.sgq.colorsapp.mvp.view.ColorsView - View
 * @see kz.colorsapp.sgq.colorsapp.mvp.presenter.interfaces.ColorsPresenter - Presenter
 *
 * @author fromsi
 * @version 0.1
 */

public class ColorsModelImpl extends ColorsModelBase implements ColorsModel {

    private int pageNumber = 0;
    private boolean loading = true;
    private RandomItems randomItems;

    private final int VISIBLE_THRESHOLD = 1;


    public ColorsModelImpl() {
        super();
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
        return getApi();
    }

    @Override
    public BaseLocal getLocalService() {
        return getLocal();
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
    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public void addPageNumber() {
        pageNumber++;
    }

    @Override
    public int getVisibleThreshold() {
        return VISIBLE_THRESHOLD;
    }
}
