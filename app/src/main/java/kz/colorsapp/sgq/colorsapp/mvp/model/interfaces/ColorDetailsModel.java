package kz.colorsapp.sgq.colorsapp.mvp.model.interfaces;

import java.util.List;

import kz.colorsapp.sgq.colorsapp.ui.model.ItemDetails;

public interface ColorDetailsModel {
    void create(int color);
    List<ItemDetails> getSaturation();
    List<ItemDetails> getLightness();
}
