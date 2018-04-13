package kz.colorsapp.sgq.colorsapp.mvp.view;

import java.util.List;

/**
 * Интерфейс для {@link kz.colorsapp.sgq.colorsapp.ui.activity.ComboActivity}
 *
 * @author fromsi
 * @version 0.1
 * @see ComboView#init(int) - (in next commit)
 * @see ComboView#initHeader(List) - (in next commit)
 * @see ComboView#initColor(List) - (in next commit)
 * @see ComboView#initColors(String, List) - (in next commit)
 * @see ComboView#getColorList() - (in next commit)
 */

public interface ComboView {
    void init(int size);

    void initHeader(int i, int j, int color);

    void initColor(int i, int color);

    void initColors(int i, String nameTypeColor, String value);

    void setBackgroundColor(int color);

    void setTextColor(int color);

    List<String> getColorList();
}
