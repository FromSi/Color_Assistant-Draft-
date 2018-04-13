package kz.colorsapp.sgq.colorsapp.ui.model;

import java.util.ArrayList;
import java.util.List;

import kz.colorsapp.sgq.colorsapp.infraestructure.networking.gson.ColorsGson;
import kz.colorsapp.sgq.colorsapp.room.table.Colors;

public class ConvertGson {

    public static List<Colors> convertColorsList(List<ColorsGson> colorsGsons){
        List<Colors> list = new ArrayList<>();
        for (int i = 0; i < colorsGsons.size(); i++) {
            list.add(new Colors(Integer.parseInt(colorsGsons.get(i).getIdCol()),
                    colorsGsons.get(i).getCol1(), colorsGsons.get(i).getCol2(),
                    colorsGsons.get(i).getCol3(), colorsGsons.get(i).getCol4(),
                    colorsGsons.get(i).getCol5(), false));
        }
        return list;
    }
}
