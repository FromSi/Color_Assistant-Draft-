package kz.colorsapp.sgq.colorsapp.mvp.model;

import kz.colorsapp.sgq.colorsapp.ui.model.ModelBaseApi;
import kz.colorsapp.sgq.colorsapp.ui.model.ModelBaseLocal;

public class ColorsModelBase {
    private ModelBaseApi api;
    private ModelBaseLocal local;

    public ColorsModelBase() {
        local = new ModelBaseLocal();
        api = new ModelBaseApi(local);
    }

    public ModelBaseApi getApi() {
        return api;
    }

    public ModelBaseLocal getLocal() {
        return local;
    }
}
