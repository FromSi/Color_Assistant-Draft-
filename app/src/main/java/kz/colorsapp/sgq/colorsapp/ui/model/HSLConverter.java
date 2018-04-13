package kz.colorsapp.sgq.colorsapp.ui.model;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class HSLConverter {
    private final static int MAX_NUMBER = 21;
    //    private final static int MAX_NUMBER_HUE = 24;

//    public static List<Integer> getHue(int color) {
//
//    }

    public static List<Integer> getSaturationList(int color) {
        List<Integer> list = new ArrayList<>();
        int[] rgb = {Color.red(color),
                Color.green(color),
                Color.blue(color)};
        int arf = (Math.max(rgb[0], Math.max(rgb[1], rgb[2])) +
                Math.min(rgb[0], Math.min(rgb[1], rgb[2]))) / 2;

        List<Integer> r = getCalcSaturationRGB(rgb[0], arf);
        List<Integer> g = getCalcSaturationRGB(rgb[1], arf);
        List<Integer> b = getCalcSaturationRGB(rgb[2], arf);

        for (int i = 0; i < MAX_NUMBER; i++) {
            list.add(Color.rgb(r.get(i), g.get(i), b.get(i)));
        }

        return list;
    }

    private static List<Integer> getCalcSaturationRGB(int rgbColor, int arf) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < MAX_NUMBER; i++) {
            if (rgbColor < 0) {
                float num = arf - ((arf - rgbColor) * (i * 0.05f));
                list.add((int) num);
            } else if (rgbColor > 128) {
                float num = arf + ((rgbColor - arf) * (i * 0.05f));
                list.add((int) num);
            } else {
                list.add(arf);
            }
        }

        return rewrite(list);
    }

    public static List<Integer> getLightnessList(int color) {
        List<Integer> list = new ArrayList<>();
        List<Integer> r = getCalcLightnessRGB(Color.red(color));
        List<Integer> g = getCalcLightnessRGB(Color.green(color));
        List<Integer> b = getCalcLightnessRGB(Color.blue(color));

        for (int i = 0; i < MAX_NUMBER; i++) {
            list.add(Color.rgb(r.get(i), g.get(i), b.get(i)));
        }

        return list;
    }

    private static List<Integer> getCalcLightnessRGB(int rgbColor) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < MAX_NUMBER - 10; i++) {
            if (rgbColor < 255) {
                float num = rgbColor + ((255 - rgbColor) * (i * 0.1f));
                list.add((int) num);
            } else {
                list.add(255);
            }
        }

        list = rewrite(list);

        for (int i = 1; i < MAX_NUMBER - 9; i++) {
            if (rgbColor > 0) {
                float num = rgbColor - (rgbColor * (i * 0.1f));
                list.add((int) num);
            } else {
                list.add(0);
            }
        }

        return list;
    }

    private static List<Integer> rewrite(List<Integer> list) {
        List<Integer> rewriteList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            rewriteList.add(list.get(list.size() - 1 - i));
        }
        return rewriteList;
    }
}
