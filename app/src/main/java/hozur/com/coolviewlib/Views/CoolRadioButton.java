package hozur.com.coolviewlib.Views;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RadioButton;

/**
 *  required :   set the parent layout < android:layoutDirection="rtl"> or <  android:layout_width="match_parent">
 */
public class CoolRadioButton extends RadioButton {

    public CoolRadioButton(Context context) {
        super(context);
        init(context,null);
    }

    public CoolRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public CoolRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        Typeface typeFace = TypeFaceUtil.getTypeFace(context, attrs);
        setTypeface(typeFace);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            setTextDirection(TEXT_DIRECTION_RTL);
        }
    }
}
