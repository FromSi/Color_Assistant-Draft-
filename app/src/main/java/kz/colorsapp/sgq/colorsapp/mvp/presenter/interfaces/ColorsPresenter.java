package kz.colorsapp.sgq.colorsapp.mvp.presenter.interfaces;

public interface ColorsPresenter {
    void handlerColorListner(int itemCount, int lastVisibleItem);
    void downloadAllDB();
    void uploadLastDB();
}
