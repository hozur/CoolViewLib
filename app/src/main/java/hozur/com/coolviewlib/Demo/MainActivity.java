package hozur.com.coolviewlib.Demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import hozur.com.coolviewlib.R;
import hozur.com.coolviewlib.Views.CoolButton;


public class MainActivity extends Activity implements View.OnClickListener {

    private CoolButton coolViewBtn;
    private CoolButton keyBoardBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coolViewBtn = ((CoolButton) findViewById(R.id.btn1));
        keyBoardBtn = ((CoolButton) findViewById(R.id.btn2));

        coolViewBtn.setOnClickListener(this);
        keyBoardBtn.setOnClickListener(this);

    }
    @Override
    public void onClick(View view){

        Intent intent=new Intent( );

        switch (view.getId()) {
            case R.id.btn1:
                intent.setClass(this,CoolViewDemo.class);
                break;

            case R.id.btn2:
                intent.setClass(this,KeybordDemo.class);
                break;
        }

        if (intent.getClass()!=null)
        {
            startActivity(intent);
        }


    }

}
