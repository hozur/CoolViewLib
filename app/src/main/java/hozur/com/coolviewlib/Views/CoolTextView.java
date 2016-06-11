package hozur.com.coolviewlib.Views;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 *  required :   set the parent layout < android:layoutDirection="rtl"> or <  android:layout_width="match_parent">
 */

public class CoolTextView extends TextView {


    public CoolTextView(Context context) {
        super(context);
        init(context, null);
    }

    public CoolTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CoolTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        Typeface typeFace = TypeFaceUtil.getTypeFace(context, attrs);
        setTypeface(typeFace);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            setTextDirection(TEXT_DIRECTION_RTL);
        }
    }


}
