package kz.colorsapp.sgq.colorsapp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import kz.colorsapp.sgq.colorsapp.R;
import kz.colorsapp.sgq.colorsapp.mvp.presenter.ComboPresenterImpl;
import kz.colorsapp.sgq.colorsapp.mvp.presenter.interfaces.ComboPresenter;
import kz.colorsapp.sgq.colorsapp.mvp.view.ComboView;

public class ComboActivity extends AppCompatActivity implements ComboView {

    @BindViews({R.id.cardOne, R.id.cardTwo,
            R.id.cardThree, R.id.cardFour,
            R.id.cardFive})
    List<CardView> cardList;

    @BindView(R.id.containerCard)
    LinearLayout containerCard;

    private List<IncludedLayout> layoutList;
    private ComboPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo);
        ButterKnife.bind(this);
        presenter = new ComboPresenterImpl(this);
    }

    @Override
    public void init(int size) {
        deleteView(size);
        initIncluds(size);
    }

    private void deleteView(int size){
        switch (size){
            case 4:
                containerCard.removeView(cardList.get(3));
                containerCard.removeView(cardList.get(4));
                cardList.remove(3);
                cardList.remove(4);
                break;
            case 5:
                containerCard.removeView(cardList.get(4));
                cardList.remove(4);
                break;
        }
    }

    private void initIncluds(int size){
        layoutList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            IncludedLayout includedLayout = new IncludedLayout();
            ButterKnife.bind(includedLayout, cardList.get(i));
            layoutList.add(includedLayout);
        }
    }

    @Override
    public void initHeader(List<Integer> colorList) {
        for (int i = 0; i < colorList.size(); i++) {
            layoutList.get(i)
                    .imgList.get(i)
                    .setBackgroundColor(colorList.get(i));
        }
    }

    @Override
    public void initColor(List<Integer> colorList) {
        for (int i = 0; i < colorList.size(); i++) {
            layoutList.get(i).imgColor
                    .setBackgroundColor(colorList.get(i));
        }
    }

    @Override
    public void initColors(String nameTypeColor, List<String> valueList) {
        for (int i = 0; i < valueList.size(); i++) {
            layoutList.get(i).nameTypeColor.setText(nameTypeColor);
            layoutList.get(i).value.setText(valueList.get(i));
        }
    }


    @Override
    public List<String> getColorList() {
        return (List<String>) getIntent().getSerializableExtra("map");
    }

    static class IncludedLayout {
        @BindViews({R.id.imgOne, R.id.imgTwo,
                R.id.imgThree, R.id.imgFour,
                R.id.imgFive})
        List<ImageView> imgList;

        @BindView(R.id.imgColor)
        ImageView imgColor;

        @BindView(R.id.nameTypeColor)
        TextView nameTypeColor;

        @BindView(R.id.value)
        TextView value;
    }
}
