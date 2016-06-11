package hozur.com.coolviewlib.Demo;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import hozur.com.coolviewlib.R;
import hozur.com.coolviewlib.keyboard.KeyboardListenRelativeLayout;
import hozur.com.coolviewlib.keyboard.KeyboardUtil;

public class KeybordDemo extends Activity {
    private KeyboardUtil keyboardUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int id = R.layout.activity_keybord_demo;
        KeyboardListenRelativeLayout view = (KeyboardListenRelativeLayout) View.inflate(this, id, null);

        setContentView(view);

        keyboardUtil = new KeyboardUtil(this);

        EditText editText = (EditText) findViewById(R.id.ev2);
        EditText editText1 = (EditText) findViewById(R.id.ev1);
        EditText editText2 = (EditText) findViewById(R.id.ev3);





        keyboardUtil.setEditText(editText);
        keyboardUtil.setEditText(editText2);
        keyboardUtil.setEditText(editText1);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    @Override
    public void onBackPressed() {
        if (keyboardUtil.isShowing()) {
            keyboardUtil.hideKeyboard();
            return;
        }
        super.onBackPressed();
    }

}
