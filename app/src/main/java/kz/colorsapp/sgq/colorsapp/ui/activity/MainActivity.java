package kz.colorsapp.sgq.colorsapp.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import kz.colorsapp.sgq.colorsapp.R;
import kz.colorsapp.sgq.colorsapp.ui.adapters.SectionsPageAdapter;
import kz.colorsapp.sgq.colorsapp.ui.fragment.FragmentColors;
import kz.colorsapp.sgq.colorsapp.ui.fragment.FragmentLikes;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupViewPager();
        init();
    }

    private void init(){
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragmetn(new FragmentColors(), getString(R.string.fragmentColorsName));
        adapter.addFragmetn(new FragmentLikes(), getString(R.string.fragmentLikesName));
        viewPager.setAdapter(adapter);
    }
}
