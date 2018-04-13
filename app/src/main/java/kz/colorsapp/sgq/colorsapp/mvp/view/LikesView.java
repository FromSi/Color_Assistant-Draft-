package kz.colorsapp.sgq.colorsapp.mvp.view;

import java.util.List;

import kz.colorsapp.sgq.colorsapp.ui.model.ItemColor;

public interface LikesView {
    void showNoItemText();
    void showColorList();
    void addItemsDB(List<ItemColor> colorList);
    void showActivityInfo(List<String> list);
}
