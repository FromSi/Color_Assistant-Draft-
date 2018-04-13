package kz.colorsapp.sgq.colorsapp.mvp.model;

import android.graphics.Color;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import kz.colorsapp.sgq.colorsapp.mvp.model.interfaces.ComboModel;
import kz.colorsapp.sgq.colorsapp.ui.model.ColorConverterUtility;

/**
 * Model - паттерн MVP
 *
 * @author fromsi
 * @version 0.1
 * @see kz.colorsapp.sgq.colorsapp.mvp.model.interfaces.ComboModel - Model
 * @see kz.colorsapp.sgq.colorsapp.mvp.view.ComboView - View
 * @see kz.colorsapp.sgq.colorsapp.mvp.presenter.interfaces.ComboPresenter - Presenter
 */

public class ComboModelImpl implements ComboModel {
    private List<Integer> colorList = new ArrayList<>();

    public ComboModelImpl(List<String> colorList) {
        for (int i = 0; i < colorList.size(); i++) {
            this.colorList.add(Color
                    .parseColor(colorList.get(i)));
        }
    }

    @Override
    public int getSize() {
        return colorList.size();
    }

    @Override
    public List<Integer> getColorList() {
        return colorList;
    }

    @Override
    public String getNameType() {
        return "Hex\nRGB\nHSV";
    }

    @Override
    public List<String> getValue() {
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < colorList.size(); i++) {
            answerList.add(ColorConverterUtility
                    .getFullAnswer(colorList.get(i)));
        }
        return answerList;
    }


}
