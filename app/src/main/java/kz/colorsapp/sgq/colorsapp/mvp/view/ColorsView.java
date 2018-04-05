package kz.colorsapp.sgq.colorsapp.mvp.view;

import java.util.HashMap;
import java.util.List;

import kz.colorsapp.sgq.colorsapp.infraestructure.networking.interfaces.ColorsAppService;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemColor;

/**
 * Интерфейс для {@link kz.colorsapp.sgq.colorsapp.ui.fragment.FragmentColors}
 *
 * @see ColorsView#showDownloadDB() - (in next commit)
 * @see ColorsView#showColorList() - (in next commit)
 * @see ColorsView#addItemsDB(List) - (in next commit)
 * @see ColorsView#showActivityInfo(List) - (in next commit)
 *
 * @author fromsi
 * @version 0.1
 */

public interface ColorsView {
    void showDownloadDB();
    void showColorList();
    void addItemsDB(List<ItemColor> colorList);
    void showActivityInfo(List<String> list);
}
