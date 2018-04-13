package kz.colorsapp.sgq.colorsapp.mvp.presenter;

import kz.colorsapp.sgq.colorsapp.mvp.model.ColorDetailsModelImpl;
import kz.colorsapp.sgq.colorsapp.mvp.model.interfaces.ColorDetailsModel;
import kz.colorsapp.sgq.colorsapp.mvp.presenter.interfaces.ColorDetailsPresenter;
import kz.colorsapp.sgq.colorsapp.mvp.view.ColorDetailsView;

public class ColorDetailsPresenterImpl implements ColorDetailsPresenter {
    private ColorDetailsView view;
    private ColorDetailsModel model;

    public ColorDetailsPresenterImpl(ColorDetailsView view) {
        this.view = view;
        model = new ColorDetailsModelImpl();
        createFragments();
    }

    private void createFragments(){
        model.create(view.getColor());
        view.createLightness(view.getColor(),
                model.getLightness());
        view.createSaturation(view.getColor(),
                model.getSaturation());
        view.instalViewPager();
    }

}
