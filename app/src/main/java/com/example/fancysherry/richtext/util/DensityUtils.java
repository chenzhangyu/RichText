package com.example.fancysherry.richtext.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by fancysherry on 15-4-22.
 */
public class DensityUtils {
  private DensityUtils()
  {
    /** cannot be instantiated **/
    throw new UnsupportedOperationException("cannot be instantiated");
  }
  public static float convertDpToPixel(float dp){
    DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
    float px = dp * (metrics.densityDpi / 160f);
    return Math.round(px);
  }


}
