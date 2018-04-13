package kz.colorsapp.sgq.colorsapp.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kz.colorsapp.sgq.colorsapp.R;
import kz.colorsapp.sgq.colorsapp.ui.adapters.RecyclerAdapterDetails;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemDetails;

public class FragmentDetails extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private RecyclerAdapterDetails adapter;
    private List<ItemDetails> list;
    private int color;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerAdapterDetails();
        adapter.addList(list);
        recyclerView.setAdapter(adapter);
    }

    public void createColors(int color, List<ItemDetails> colorList){
        this.color = color;
        this.list = colorList;
    }
}
