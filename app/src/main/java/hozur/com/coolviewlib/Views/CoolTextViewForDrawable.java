
package hozur.com.coolviewlib.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 *  required :   set the parent layout < android:layoutDirection="rtl"> or <  android:layout_width="match_parent">
 */

public class CoolTextViewForDrawable extends TextView {


    public CoolTextViewForDrawable(Context context) {
        super(context);
        init(context,null);
    }

    public CoolTextViewForDrawable(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public CoolTextViewForDrawable(Context context, AttributeSet attrs, int defStyleAttr) {
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

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        Drawable drawableLeft = drawables[2];
        if (drawableLeft != null) {

            float textWidth = getPaint().measureText(getText().toString());
            int drawablePadding = getCompoundDrawablePadding();
            int drawableWidth = 0;
            drawableWidth = drawableLeft.getIntrinsicWidth();
            float bodyWidth = textWidth + drawableWidth + drawablePadding;
            setPadding(0, 0, (int)(getWidth() - bodyWidth), 0);
            canvas.translate((getWidth() - bodyWidth) / 2, 0);
        }
        super.onDraw(canvas);
    }


}
