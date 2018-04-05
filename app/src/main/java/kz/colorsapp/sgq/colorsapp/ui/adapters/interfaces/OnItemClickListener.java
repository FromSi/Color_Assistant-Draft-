package kz.colorsapp.sgq.colorsapp.ui.adapters.interfaces;

import android.view.View;

import kz.colorsapp.sgq.colorsapp.ui.model.ItemColor;

public interface OnItemClickListener {
    void onItemLikeClick(View view, int id, boolean like);
    void onItemViewClick(View view, ItemColor itemColor);
}
