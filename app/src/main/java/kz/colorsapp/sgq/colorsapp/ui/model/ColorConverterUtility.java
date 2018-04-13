package kz.colorsapp.sgq.colorsapp.ui.model;

import android.graphics.Color;

import java.text.DecimalFormat;

public class ColorConverterUtility {

    public static String getHex(int color) {
        String hex = Integer.toHexString(color);
        return "#"+hex.substring(2);
    }

    public static String getRGB(int color) {
        return Color.red(color) + ", " +
                Color.green(color) + ", " +
                Color.blue(color);
    }

    public static String getHSV(int color) {
        float[] a = new float[3];
        Color.colorToHSV(color, a);
        String h = String.valueOf(new DecimalFormat("0.##").format(a[0]));
        String s = String.valueOf(new DecimalFormat("0.##").format(a[1]));
        String v = String.valueOf(new DecimalFormat("0.##").format(a[2]));
        return h + ", " + s + ", " + v;
    }

    public static String getFullAnswer(int color){
        return getHex(color) +"\n"+
                getRGB(color) +"\n"+
                getHSV(color);
    }
}
