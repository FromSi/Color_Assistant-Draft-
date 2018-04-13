package kz.colorsapp.sgq.colorsapp.mvp.model;

import java.util.ArrayList;
import java.util.List;

import kz.colorsapp.sgq.colorsapp.mvp.model.interfaces.LikesModel;
import kz.colorsapp.sgq.colorsapp.room.table.Colors;
import kz.colorsapp.sgq.colorsapp.ui.model.BaseLocal;
import kz.colorsapp.sgq.colorsapp.ui.model.ItemColor;
import kz.colorsapp.sgq.colorsapp.ui.model.RandomItems;

public class LikesModelImpl implements LikesModel {

    private BaseLocal local;

    public LikesModelImpl() {
        local = new BaseLocal();
    }

    @Override
    public List<ItemColor> getItemColor(List<Colors> colors) {
        List<ItemColor> list = new ArrayList<>();

        for (int i = 0; i < colors.size(); i++) {
            List<String> stringList = new ArrayList<>();
            stringList.add(colors.get(i).getColOne());
            stringList.add(colors.get(i).getColTwo());
            stringList.add(colors.get(i).getColThree());

            if (colors.get(i).getColFour() != null)
                stringList.add(colors.get(i).getColFour());

            if (colors.get(i).getColFive() != null)
                stringList.add(colors.get(i).getColFive());

            list.add(new ItemColor(colors.get(i).getIdCol(),
                    stringList, colors.get(i).isLike()));
        }
        return list;
    }

    @Override
    public BaseLocal getLocalService() {
        return local;
    }
}
