package util;

import java.text.DecimalFormat;

public class Utils {

    public static String formatNumber(int value){
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String formattedDate = formatter.format(value);
        return formattedDate;
    }
}
