package kz.colorsapp.sgq.colorsapp.mvp.model.base;

import kz.colorsapp.sgq.colorsapp.ui.model.BaseApi;
import kz.colorsapp.sgq.colorsapp.ui.model.BaseLocal;

/**
 * Базовый class для {@link kz.colorsapp.sgq.colorsapp.mvp.model.ColorsModelImpl}
 *
 * @see ColorsModelBase#api - API WebServer'а
 * @see ColorsModelBase#local - Локальная БД андроид приложения
 *
 * @author fromsi
 * @version 0.1
 */

public class ColorsModelBase {
    private BaseApi api;
    private BaseLocal local;

    public ColorsModelBase() {
        local = new BaseLocal();
        api = new BaseApi(local);
    }

    public BaseApi getApi() {
        return api;
    }

    public BaseLocal getLocal() {
        return local;
    }
}
