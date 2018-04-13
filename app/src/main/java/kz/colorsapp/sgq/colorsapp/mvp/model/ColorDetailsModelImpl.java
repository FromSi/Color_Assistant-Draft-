package kz.colorsapp.sgq.colorsapp.mvp.model;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

import kz.colorsapp.sgq.colorsapp.mvp.model.interfaces.ColorDetailsModel;
import kz.colorsapp.sgq.colorsapp.ui.model.ColorConverterUtility;
import kz.colorsapp.sgq.colorsapp.ui.model.HSLConverter;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemDetails;

public class ColorDetailsModelImpl implements ColorDetailsModel {
    private List<ItemDetails> saturationList = new ArrayList<>();
    private List<ItemDetails> lightnessList = new ArrayList<>();

    @Override
    public void create(int color) {
        List<Integer> saturation = HSLConverter.getSaturationList(color);
        List<Integer> lightness = HSLConverter.getLightnessList(color);

        for (int i = 0; i < saturation.size(); i++) {
            saturationList
                    .add(new ItemDetails(ColorConverterUtility
                            .getFullAnswer(saturation.get(i)),
                            saturation.get(i)));
        }

        for (int i = 0; i < lightness.size(); i++) {
            lightnessList
                    .add(new ItemDetails(ColorConverterUtility
                            .getFullAnswer(lightness.get(i)),
                            lightness.get(i)));
        }

    }

    @Override
    public List<ItemDetails> getSaturation() {
        return saturationList;
    }

    @Override
    public List<ItemDetails> getLightness() {
        return lightnessList;
    }


}
