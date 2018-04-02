package kz.colorsapp.sgq.colorsapp.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kz.colorsapp.sgq.colorsapp.R;
import kz.colorsapp.sgq.colorsapp.ui.adapters.RecyclerAdapterColors;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemColor;

public class FragmentColors extends Fragment {

    @BindView(R.id.rv_colors)
    RecyclerView recyclerView;

    private LinearLayoutManager layoutManager;
    private RecyclerAdapterColors adapterColors;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_colors, container, false);
        ButterKnife.bind(this, view);
        init(view.getContext());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void init(Context context){
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapterColors = new RecyclerAdapterColors();
        recyclerView.setAdapter(adapterColors);


        List<ItemColor> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        list2.add("#607d8b");
        list2.add("#6d4c41");
        list2.add("#d84315");
        list2.add("#1976d2");
        list2.add("#880e4f");
        list3.add("#6d4c41");
        list3.add("#bbdefb");
        list3.add("#fff9c4");
        list3.add("#880e4f");
        list4.add("#ff8f00");
        list4.add("#b9f6ca");
        list4.add("#b388ff");
        list.add(new ItemColor(list2, false));
        list.add(new ItemColor(list3, true));
        list.add(new ItemColor(list4, false));


        adapterColors.addItems(list);
        adapterColors.notifyDataSetChanged();
    }
}
