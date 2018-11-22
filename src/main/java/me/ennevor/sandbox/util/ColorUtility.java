package me.ennevor.sandbox.util;

import java.awt.*;

public class ColorUtility {

    public static Color colorFromRgbString(String colorString) {
        int r = Integer.valueOf(colorString.substring(0, 3));
        int g = Integer.valueOf(colorString.substring(3, 6));
        int b = Integer.valueOf(colorString.substring(6));
        Color color = new Color(r, g, b);
        return color;
    }
}
