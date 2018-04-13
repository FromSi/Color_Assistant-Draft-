package kz.colorsapp.sgq.colorsapp.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kz.colorsapp.sgq.colorsapp.R;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemDetails;

public class RecyclerAdapterDetails extends RecyclerView.Adapter<RecyclerAdapterDetails.DetailsHolder> {
    List<ItemDetails> list = new ArrayList<>();

    public void addList(List<ItemDetails> list) {
        this.list.addAll(list);
    }

    @NonNull
    @Override
    public RecyclerAdapterDetails.DetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_details, parent, false);
        return new DetailsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterDetails.DetailsHolder holder, int position) {
        holder.init(list.get(position));
        holder.setPercent(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class DetailsHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgLine)
        ImageView imgLine;
        @BindView(R.id.imgColor)
        ImageView imgColor;
        @BindView(R.id.nameTypeColor)
        TextView nameTypeColor;
        @BindView(R.id.value)
        TextView value;
        @BindView(R.id.percent)
        TextView percent;

        public DetailsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void init(ItemDetails itemDetails) {
            imgLine.setBackgroundColor(itemDetails.getColor());
            imgColor.setBackgroundColor(itemDetails.getColor());
            nameTypeColor.setText("Hex\nRGB\nHSV");
            value.setText(itemDetails.getValue());
        }

        void setPercent(int position) {
            int i = 100 - position * 5;
            percent.setText(String.valueOf(i) + (char) 37);
        }
    }
}
