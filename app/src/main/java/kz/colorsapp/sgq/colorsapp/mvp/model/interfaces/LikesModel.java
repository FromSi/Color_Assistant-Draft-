package kz.colorsapp.sgq.colorsapp.mvp.model.interfaces;

import java.util.List;

import kz.colorsapp.sgq.colorsapp.room.table.Colors;
import kz.colorsapp.sgq.colorsapp.ui.model.BaseLocal;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemColor;

public interface LikesModel {
    List<ItemColor> getItemColor(List<Colors> colors);
    BaseLocal getLocalService();
}
