package kz.colorsapp.sgq.colorsapp.ui.activity;

import android.content.Intent;
import android.graphics.Color;
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
import butterknife.OnClick;
import kz.colorsapp.sgq.colorsapp.R;
import kz.colorsapp.sgq.colorsapp.mvp.presenter.ComboPresenterImpl;
import kz.colorsapp.sgq.colorsapp.mvp.presenter.interfaces.ComboPresenter;
import kz.colorsapp.sgq.colorsapp.mvp.view.ComboView;

public class ComboActivity extends AppCompatActivity implements ComboView {

    @BindViews({R.id.cardOne, R.id.cardTwo,
            R.id.cardThree, R.id.cardFour,
            R.id.cardFive})
    List<CardView> cardList;

    @BindView(R.id.text)
    TextView text;

    @BindView(R.id.background)
    CardView background;

    @BindViews({R.id.backgroundColorOne, R.id.backgroundColorTwo,
            R.id.backgroundColorThree, R.id.backgroundColorFour,
            R.id.backgroundColorFive})
    List<ImageView> backgroundColorList;

    @BindViews({R.id.textColorOne, R.id.textColorTwo,
            R.id.textColorThree, R.id.textColorFour,
            R.id.textColorFive})
    List<ImageView> textColorList;

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
        removeViews(size);
        initIncluds(size);
    }

    private void removeViews(int size) {
        switch (size) {
            case 3:
                containerCard.removeView(cardList.get(3));
                containerCard.removeView(cardList.get(4));
                break;
            case 4:
                containerCard.removeView(cardList.get(4));
                break;
        }
    }

    private void initIncluds(int size) {
        layoutList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            IncludedLayout includedLayout = new IncludedLayout();
            ButterKnife.bind(includedLayout, cardList.get(i));
            layoutList.add(includedLayout);
        }
    }

    private void initExmaple(int i, int color){
            backgroundColorList.get(i).setVisibility(View.VISIBLE);
            backgroundColorList.get(i).setBackgroundColor(color);
            textColorList.get(i).setVisibility(View.VISIBLE);
            textColorList.get(i).setBackgroundColor(color);
            if (i == 0)
            background.setBackgroundColor(color);
            if (i == 1)
            text.setTextColor(color);
    }

    @OnClick({R.id.backgroundColorOne, R.id.backgroundColorTwo,
            R.id.backgroundColorThree, R.id.backgroundColorFour,
            R.id.backgroundColorFive})
    public void onBackgrounColorClick(View view) {
        switch (view.getId()) {
            case R.id.backgroundColorOne:
                presenter.handlerBackgroundColor(0);
                break;
            case R.id.backgroundColorTwo:
                presenter.handlerBackgroundColor(1);
                break;
            case R.id.backgroundColorThree:
                presenter.handlerBackgroundColor(2);
                break;
            case R.id.backgroundColorFour:
                presenter.handlerBackgroundColor(3);
                break;
            case R.id.backgroundColorFive:
                presenter.handlerBackgroundColor(4);
                break;
        }
    }

    @OnClick({R.id.textColorOne, R.id.textColorTwo,
            R.id.textColorThree, R.id.textColorFour,
            R.id.textColorFive})
    public void onTextColorClick(View view) {
        switch (view.getId()) {
            case R.id.textColorOne:
                presenter.handlerTextColor(0);
                break;
            case R.id.textColorTwo:
                presenter.handlerTextColor(1);
                break;
            case R.id.textColorThree:
                presenter.handlerTextColor(2);
                break;
            case R.id.textColorFour:
                presenter.handlerTextColor(3);
                break;
            case R.id.textColorFive:
                presenter.handlerTextColor(4);
                break;
        }
    }

    @OnClick({R.id.cardOne, R.id.cardTwo,
            R.id.cardThree, R.id.cardFour,
            R.id.cardFive})
    public void onCardClick(View view){
        Intent intent = new Intent(this, ColorDetailsActivity.class);
        switch (view.getId()){
            case R.id.cardOne:
                intent.putExtra("color",presenter.getColor(0));
                startActivity(intent);
                break;
            case R.id.cardTwo:
                intent.putExtra("color",presenter.getColor(1));
                startActivity(intent);
                break;
            case R.id.cardThree:
                intent.putExtra("color",presenter.getColor(2));
                startActivity(intent);
                break;
            case R.id.cardFour:
                intent.putExtra("color",presenter.getColor(3));
                startActivity(intent);
                break;
            case R.id.cardFive:
                intent.putExtra("color",presenter.getColor(4));
                startActivity(intent);
                break;
        }
    }

    @Override
    public void initHeader(int i, int j, int color) {
        layoutList.get(i)
                .imgList.get(j)
                .setBackgroundColor(color);
        layoutList.get(i)
                .imgList.get(j)
                .setVisibility(View.VISIBLE);
    }

    @Override
    public void initColor(int i, int color) {
        layoutList.get(i).imgColor
                .setBackgroundColor(color);
        initExmaple(i, color);
    }

    @Override
    public void initColors(int i, String nameTypeColor, String value) {
        layoutList.get(i).nameTypeColor.setText(nameTypeColor);
        layoutList.get(i).value.setText(value);

    }

    @Override
    public void setBackgroundColor(int color) {
        background.setBackgroundColor(color);
    }

    @Override
    public void setTextColor(int color) {
        text.setTextColor(color);
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
