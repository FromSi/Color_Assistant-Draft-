package kz.colorsapp.sgq.colorsapp.ui.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kz.colorsapp.sgq.colorsapp.R;
import kz.colorsapp.sgq.colorsapp.mvp.presenter.ColorDetailsPresenterImpl;
import kz.colorsapp.sgq.colorsapp.mvp.presenter.interfaces.ColorDetailsPresenter;
import kz.colorsapp.sgq.colorsapp.mvp.view.ColorDetailsView;
import kz.colorsapp.sgq.colorsapp.ui.adapters.SectionsPageAdapter;
import kz.colorsapp.sgq.colorsapp.ui.fragment.FragmentColors;
import kz.colorsapp.sgq.colorsapp.ui.fragment.FragmentDetails;
import kz.colorsapp.sgq.colorsapp.ui.fragment.FragmentLikes;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemDetails;

public class ColorDetailsActivity extends AppCompatActivity implements ColorDetailsView {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    private SectionsPageAdapter adapter;
    private ColorDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_details);
        ButterKnife.bind(this);
        init();
    }

    private void init(){
        tabLayout.setupWithViewPager(viewPager);
        adapter = new SectionsPageAdapter(getSupportFragmentManager());
        presenter =  new ColorDetailsPresenterImpl(this);
    }

    @Override
    public int getColor() {
        return getIntent().getIntExtra("color", Color.RED);
    }

    @Override
    public void createSaturation(int color, List<ItemDetails> itemList) {
        FragmentDetails saturation = new FragmentDetails();
        saturation.createColors(color, itemList);
        adapter.addFragmetn(saturation, getString(R.string.fragmentSaturationName));
    }

    @Override
    public void createLightness(int color, List<ItemDetails> itemList) {
        FragmentDetails lightness = new FragmentDetails();
        lightness.createColors(color, itemList);
        adapter.addFragmetn(lightness, getString(R.string.fragmentLightnessName));
    }

    @Override
    public void instalViewPager() {
        viewPager.setAdapter(adapter);
    }
}
