package kz.colorsapp.sgq.colorsapp.mvp.model.interfaces;

import java.util.List;

/**
 * Интерфейс для {@link kz.colorsapp.sgq.colorsapp.mvp.model.ComboModelImpl}
 *
 * @see ComboModel#getSize() - (in next commit)
 * @see ComboModel#colorList() - (in next commit)
 * @see ComboModel#getNameType() - (in next commit)
 * @see ComboModel#getValue() - (in next commit)
 *
 * @author fromsi
 * @version 0.1
 */

public interface ComboModel {
    int getSize();
    List<Integer> colorList();
    String getNameType();
    List<String> getValue();
}
