package kz.colorsapp.sgq.colorsapp.mvp.presenter.interfaces;

/**
 * Интерфейс для {@link kz.colorsapp.sgq.colorsapp.mvp.presenter.ComboPresenterImpl}
 *
 * @author fromsi
 * @version 0.1
 */

public interface ComboPresenter {
    void handlerTextColor(int i);
    void handlerBackgroundColor(int i);
    int getColor(int i);
}
