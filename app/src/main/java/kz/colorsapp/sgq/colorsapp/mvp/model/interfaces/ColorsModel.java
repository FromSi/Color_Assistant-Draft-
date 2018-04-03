package kz.colorsapp.sgq.colorsapp.mvp.model.interfaces;


import java.util.List;

import io.reactivex.Observable;
import kz.colorsapp.sgq.colorsapp.infraestructure.networking.gson.ColorsGson;
import kz.colorsapp.sgq.colorsapp.room.table.Colors;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemColor;
import kz.colorsapp.sgq.colorsapp.ui.model.ModelBaseApi;
import kz.colorsapp.sgq.colorsapp.ui.model.ModelBaseLocal;

public interface ColorsModel {
    List<ItemColor> getItemColor(List<Colors> colors);
    ModelBaseApi getApiService();
    ModelBaseLocal getLocalService();
    boolean isLoading();
    void setLoading(boolean loading);
    int getPageNumber();
    void addPageNumber();
    int getVisibleThreshold();
}
