package kz.colorsapp.sgq.colorsapp.ui.adapters;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.like.LikeButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import kz.colorsapp.sgq.colorsapp.R;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemColor;

public class RecyclerAdapterColors extends RecyclerView.Adapter<RecyclerAdapterColors.HolderColors> {

    List<ItemColor> listItems = new ArrayList<>();

    public void addItems(List<ItemColor> listItems) {
        this.listItems.addAll(listItems);
    }

    @NonNull
    @Override
    public HolderColors onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_colors, parent, false);
        return new HolderColors(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderColors holder, int position) {
        holder.setImagesView(listItems.get(position));
        holder.setLiked(listItems.get(position).isLike());
        holder.onClick();
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    class HolderColors extends RecyclerView.ViewHolder {

        @BindViews({R.id.itemOne, R.id.itemTwo,
                R.id.itemThree, R.id.itemFour,
                R.id.itemFive})
        List<ImageView> listImage;

        @BindView(R.id.like)
        LikeButton likeButton;

        @BindView(R.id.items)
        LinearLayout items;

        @BindView(R.id.itemsTwo)
        LinearLayout itemsTwo;

        HolderColors(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void setImagesView(ItemColor itemColor) {

            for (int i = 0; i < itemColor.getColors().size(); i++) {
                if (itemColor.getColors().get(i) != null) {
                    listImage.get(i)
                            .setBackgroundColor(Color
                                    .parseColor(itemColor
                                            .getColors()
                                            .get(i)));
                    listImage.get(i)
                            .setVisibility(View.VISIBLE);
                }
            }
        }

        private void setLiked(boolean b) {
            likeButton.setLiked(b);
        }

        private void onClick() {
            items.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemsTwo.getVisibility() != View.VISIBLE)
                        itemsTwo.setVisibility(View.VISIBLE);
                    else
                        itemsTwo.setVisibility(View.GONE);
                }
            });
        }
    }
}
