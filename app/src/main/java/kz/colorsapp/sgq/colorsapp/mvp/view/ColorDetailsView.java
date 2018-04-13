package kz.colorsapp.sgq.colorsapp.mvp.view;

import java.util.List;

import kz.colorsapp.sgq.colorsapp.ui.model.ItemDetails;

public interface ColorDetailsView {
    void createSaturation(int color, List<ItemDetails> itemList);
    void createLightness(int color, List<ItemDetails> itemList);
    void instalViewPager();
    int getColor();
}
