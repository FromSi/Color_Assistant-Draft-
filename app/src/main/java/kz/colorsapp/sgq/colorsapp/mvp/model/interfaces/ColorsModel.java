package kz.colorsapp.sgq.colorsapp.mvp.model.interfaces;


import java.util.List;

import kz.colorsapp.sgq.colorsapp.infraestructure.networking.gson.ColorsGson;
import kz.colorsapp.sgq.colorsapp.room.table.Colors;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemColor;
import kz.colorsapp.sgq.colorsapp.ui.model.BaseApi;
import kz.colorsapp.sgq.colorsapp.ui.model.BaseLocal;

/**
 * Интерфейс для {@link kz.colorsapp.sgq.colorsapp.mvp.model.ColorsModelImpl}
 *
 * @see ColorsModel#initRandom(int) - (in next commit)
 * @see ColorsModel#getNumbers() - (in next commit)
 * @see ColorsModel#getItemColor(List) - (in next commit)
 * @see ColorsModel#getApiService() - (in next commit)
 * @see ColorsModel#getLocalService() - (in next commit)
 * @see ColorsModel#isLoading() - (in next commit)
 * @see ColorsModel#setLoading(boolean) - (in next commit)
 * @see ColorsModel#addPageNumber() - (in next commit)
 * @see ColorsModel#getVisibleThreshold() - (in next commit)
 *
 * @author fromsi
 * @version 0.1
 */

public interface ColorsModel {
    void initRandom(int size);
    int[] getNumbers();
    int getCheck();
    List<ItemColor> getItemColor(List<Colors> colors);
    BaseApi getApiService();
    BaseLocal getLocalService();
    boolean isLoading();
    void setLoading(boolean loading);
    void setRandomSize(int size);
    int getVisibleThreshold();
    List<ItemColor> converterToItemColor(List<ColorsGson> list);
}
