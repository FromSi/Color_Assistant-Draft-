package kz.colorsapp.sgq.colorsapp.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kz.colorsapp.sgq.colorsapp.R;
import kz.colorsapp.sgq.colorsapp.mvp.presenter.LikesPresenterImpl;
import kz.colorsapp.sgq.colorsapp.mvp.presenter.interfaces.ColorsPresenter;
import kz.colorsapp.sgq.colorsapp.mvp.view.ColorsView;
import kz.colorsapp.sgq.colorsapp.mvp.view.LikesView;
import kz.colorsapp.sgq.colorsapp.ui.activity.ComboActivity;
import kz.colorsapp.sgq.colorsapp.ui.adapters.RecyclerAdapterColors;
import kz.colorsapp.sgq.colorsapp.ui.adapters.interfaces.OnItemClickListener;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemColor;

public class FragmentLikes extends Fragment implements ColorsView{

    @BindView(R.id.rv_colors)
    RecyclerView rv_colors;

    @BindView(R.id.textNoItem)
    TextView textNoItem;

    private LinearLayoutManager layoutManager;
    private RecyclerAdapterColors adapterColors;

    private ColorsPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_colors, container, false);
        ButterKnife.bind(this, view);
        init(view.getContext());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new LikesPresenterImpl(this);
    }

    private void init(Context context) {
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_colors.setLayoutManager(layoutManager);
        adapterColors = new RecyclerAdapterColors();

//        adapterColors.setHasStableIds(true);

        adapterColors = new RecyclerAdapterColors();
        rv_colors.setAdapter(adapterColors);
        onClickListenerAdapter();
    }

    private void onClickListenerAdapter() {
        adapterColors.SetOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemLikeClick(View view, int id, boolean like) {
                presenter.onItemLikeClick(view, id, like);
            }

            @Override
            public void onItemViewClick(View view, ItemColor itemColor) {
                presenter.onItemViewClick(view, itemColor);
            }
        });
    }

    @Override
    public void showLoadDB() {
        textNoItem.setVisibility(View.VISIBLE);
        rv_colors.setVisibility(View.GONE);
    }

    @Override
    public void showColorList() {
        textNoItem.setVisibility(View.GONE);
        rv_colors.setVisibility(View.VISIBLE);
    }

    @Override
    public void addItemsDB(List<ItemColor> colorList) {
        adapterColors.addItems(colorList);
    }

    @Override
    public List<ItemColor> getColorList() {
        return adapterColors.getColorItemList();
    }

    @Override
    public void clearItemsDB() {
        adapterColors.clearItems();
        adapterColors.notifyDataSetChanged();
    }

    @Override
    public void updateItemsDB(int index) {

    }

    @Override
    public void showActivityInfo(List<String> list) {
        Intent intent = new Intent(getContext(), ComboActivity.class);
        intent.putExtra("map", (Serializable) list);
        startActivity(intent);
    }
}
