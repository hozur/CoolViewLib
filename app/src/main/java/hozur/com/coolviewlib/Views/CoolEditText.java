
package hozur.com.coolviewlib.Views;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 *  required :   set the parent layout < android:layoutDirection="rtl"> or <  android:layout_width="match_parent">
 */
public   class CoolEditText extends EditText {

	public   static final int D_RIGHT =1<<2 ;
	public   static final int D_LEFT =1<<3 ;

	public   CoolEditText(Context context) {
		super(context);
		init(context,null);
	}

	public CoolEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context,attrs);
	}

	public CoolEditText(Context context, AttributeSet attrs, int defStyleAttr) {
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

	public   void setDrawable(Drawable drawable,int type){

		if(drawable!=null) {
			drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
			if (type == D_RIGHT) {
				setCompoundDrawables(null, null, drawable, null);
			}
			if (type == D_LEFT) {
				setCompoundDrawables(drawable, null, null, null);
			}
		}

	}
	public   void setDrawable(Drawable drawable){

		if(drawable!=null) {
			drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
			setCompoundDrawables(null, null, drawable, null);
		}

	}


}
