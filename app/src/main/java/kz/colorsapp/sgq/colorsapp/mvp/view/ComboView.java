package kz.colorsapp.sgq.colorsapp.mvp.view;

import java.util.List;

/**
 * Интерфейс для {@link kz.colorsapp.sgq.colorsapp.ui.activity.ComboActivity}
 *
 * @see ComboView#init(int) - (in next commit)
 * @see ComboView#initHeader(List) - (in next commit)
 * @see ComboView#initColor(List) - (in next commit)
 * @see ComboView#initColors(String, List) - (in next commit)
 * @see ComboView#getColorList() - (in next commit)
 *
 * @author fromsi
 * @version 0.1
 */

public interface ComboView {
    void init(int size);

    void initHeader(List<Integer> colorList);

    void initColor(List<Integer> colorList);

    void initColors(String nameTypeColor, List<String> valueList);

    List<String> getColorList();
}
