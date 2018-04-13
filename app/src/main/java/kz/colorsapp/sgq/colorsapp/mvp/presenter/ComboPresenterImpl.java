package kz.colorsapp.sgq.colorsapp.mvp.presenter;

import kz.colorsapp.sgq.colorsapp.mvp.model.ComboModelImpl;
import kz.colorsapp.sgq.colorsapp.mvp.model.interfaces.ComboModel;
import kz.colorsapp.sgq.colorsapp.mvp.presenter.interfaces.ComboPresenter;
import kz.colorsapp.sgq.colorsapp.mvp.view.ComboView;

/**
 * Presenter - паттерн MVP
 *
 * @version 0.1
 * @see ComboModel - Model
 * @see ComboView - View
 * @see ComboPresenter - Presenter
 * <p>
 * * @author fromsi
 */

public class ComboPresenterImpl implements ComboPresenter {
    private ComboView view;
    private ComboModel model;

    public ComboPresenterImpl(ComboView view) {
        this.view = view;
        model = new ComboModelImpl(view.getColorList());
        init();
    }

    private void init() {
        view.init(model.getSize());
        initHeader();
        initColor();
        initColors();
    }

    private void initHeader() {
        for (int i = 0; i < model.getColorList().size(); i++) {
            for (int j = 0; j < model.getColorList().size(); j++) {
                if (i + j < model.getColorList().size()){
                    view.initHeader(i, j, model.getColorList().get(i+j));
                }
            }
        }
    }

    private void initColor() {
        for (int i = 0; i < model.getColorList().size(); i++) {
            view.initColor(i, model.getColorList().get(i));
        }
    }

    private void initColors() {
        for (int i = 0; i < model.getSize(); i++) {
            view.initColors(i, model.getNameType(),
                    model.getValue().get(i));
        }
    }

    @Override
    public void handlerTextColor(int i) {
        view.setTextColor(model.getColorList().get(i));
    }

    @Override
    public void handlerBackgroundColor(int i) {
        view.setBackgroundColor(model.getColorList().get(i));
    }

    @Override
    public int getColor(int i) {
        return model.getColorList().get(i);
    }
}
