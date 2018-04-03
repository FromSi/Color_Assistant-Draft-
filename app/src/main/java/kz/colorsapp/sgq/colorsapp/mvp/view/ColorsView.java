package kz.colorsapp.sgq.colorsapp.mvp.view;

import java.util.List;

import kz.colorsapp.sgq.colorsapp.infraestructure.networking.interfaces.ColorsAppService;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemColor;

public interface ColorsView {
    void showDownloadDB();
    void showColorList();
    void addItemsDB(List<ItemColor> colorList);
}
