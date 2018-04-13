package kz.colorsapp.sgq.colorsapp.ui.model;

import java.util.List;

/**
 * Модель для {@link kz.colorsapp.sgq.colorsapp.ui.adapters.RecyclerAdapterColors}
 *
 * @see ItemColor#colors - List цветов {3..5}
 * @see ItemColor#like - Статус строки из таблицы
 * @see ItemColor#id - (in next commit)
 *
 * @author fromsi
 * @version 0.2
 */

public class ItemColor {
    private int id;
    private List<String> colors;
    private boolean like;

    public ItemColor(int id, List<String> colors, boolean like) {
        this.id = id;
        this.colors = colors;
        this.like = like;
    }

    public int getId() {
        return id;
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
