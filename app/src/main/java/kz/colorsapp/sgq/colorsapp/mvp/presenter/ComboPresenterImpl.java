package kz.colorsapp.sgq.colorsapp.mvp.presenter;

import kz.colorsapp.sgq.colorsapp.mvp.model.ComboModelImpl;
import kz.colorsapp.sgq.colorsapp.mvp.model.interfaces.ComboModel;
import kz.colorsapp.sgq.colorsapp.mvp.presenter.interfaces.ComboPresenter;
import kz.colorsapp.sgq.colorsapp.mvp.view.ComboView;

/**
 * Presenter - паттерн MVP
 * @see ComboModel - Model
 * @see ComboView - View
 * @see ComboPresenter - Presenter
 *
 * @author fromsi
 * @version 0.1
 */

public class ComboPresenterImpl implements ComboPresenter {
    private ComboView view;
    private ComboModel model;

    public ComboPresenterImpl(ComboView view) {
        this.view = view;
        model = new ComboModelImpl(view.getColorList());
        init();
    }

    private void init(){
        view.init(model.getSize());
        view.initHeader(model.colorList());
        view.initColor(model.colorList());
        view.initColors(model.getNameType(),
                model.getValue());
    }

}
