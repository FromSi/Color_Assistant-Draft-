package kz.colorsapp.sgq.colorsapp.mvp.presenter.interfaces;

import android.view.View;

import kz.colorsapp.sgq.colorsapp.ui.model.ItemColor;

/**
 * Интерфейс для {@link kz.colorsapp.sgq.colorsapp.mvp.presenter.ColorsPresenterImpl}
 *
 * @see ColorsPresenter#handlerColorListner(int, int) - (in next commit)
 * @see ColorsPresenter#downloadAllDB() - (in next commit)
 * @see ColorsPresenter#onItemLikeClick(View, int, boolean) - (in next commit)
 * @see ColorsPresenter#onItemViewClick(View, ItemColor) - (in next commit)
 *
 * @author fromsi
 * @version 0.1
 */

public interface ColorsPresenter {
    void handlerColorListner(int itemCount, int lastVisibleItem);
    void downloadAllDB();
    void uploadLastDB();
    void onItemLikeClick(View view, int id, boolean like);
    void onItemViewClick(View view, ItemColor itemColor);
}
