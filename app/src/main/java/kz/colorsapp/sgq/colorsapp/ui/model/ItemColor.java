package kz.colorsapp.sgq.colorsapp.ui.model;

import java.util.List;

/**
 * Модель для {@link kz.colorsapp.sgq.colorsapp.ui.adapters.RecyclerAdapterColors}
 *
 * @see ItemColor#colors - List цветов {3..5}
 * @see ItemColor#like - Статус строки из таблицы
 *
 * @author fromsi
 * @version 0.1
 */

public class ItemColor {
    private List<String> colors;
    private boolean like;


    public ItemColor(List<String> colors, boolean like) {
        this.colors = colors;
        this.like = like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public boolean isLike() {
        return like;
    }

    public List<String> getColors() {
        return colors;
    }
}
