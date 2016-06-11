package hozur.com.coolviewlib.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import java.util.LinkedHashMap;
import java.util.Map;

import hozur.com.coolviewlib.R;


public class TypeFaceUtil {

    public static final String DEFAULT_FONT = "msuighur";
    private static Map<String, Typeface> typefaceMap = new LinkedHashMap<>();

    public static Typeface getTypeFace(Context context, AttributeSet attr) {
        TypedArray a = context.obtainStyledAttributes(attr, R.styleable.CoolView);//获取我们自定属性集合
        String fontName = a.getString(R.styleable.CoolView_font);//从这个集合中获取font属性的值（注意：CoolView_font连写）
        a.recycle();//回收集合
        return getTypeFace(context, fontName);
    }

    public static Typeface getTypeFace(Context context, String fontName) {

        //从缓存Map中查询
        if (typefaceMap.containsKey(fontName)) {
            return typefaceMap.get(fontName);
        }

        Typeface fromAsset = null;
        if (fontName != null && !fontName.equals("")) {
            try {

                fromAsset = Typeface.createFromAsset(context.getAssets(), "fonts/" + fontName + ".ttf");
                //想缓存Map中添加
                typefaceMap.put(fontName, fromAsset);

            } catch (RuntimeException ignored) {
                ignored.printStackTrace();
            }
        } else {
            //如果没设置字体，就用默认字体，这个最终到35行
            return getTypeFace(context, DEFAULT_FONT);
        }

        return fromAsset;
    }
}
