package com.example.fatmaali.activity119;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class ButtonAnimation extends AppCompatActivity {
    Button btn_settings,btn_email,btn_home,btn_share,btn_help;
    Animation tran_in,tran_out,rotate;
    Boolean open=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_animation);

        btn_settings=(Button)findViewById(R.id.btn_setting);
        btn_email=(Button)findViewById(R.id.btn_email);
        btn_home=(Button)findViewById(R.id.btn_home);
        btn_share=(Button)findViewById(R.id.btn_share);
        btn_help=(Button)findViewById(R.id.btn_help);

        tran_in= AnimationUtils.loadAnimation(this,R.anim.tran_in);
        tran_out= AnimationUtils.loadAnimation(this,R.anim.tran_out);
        rotate= AnimationUtils.loadAnimation(this,R.anim.rotate);

        btn_settings.bringToFront();
    }


    public void btn_setting(View view) {
        if (open){
            open=false;
            btn_settings.startAnimation(rotate);
            btn_email.startAnimation(tran_in);
            btn_home.startAnimation(tran_in);
            btn_share.startAnimation(tran_in);
            btn_help.startAnimation(tran_in);

            btn_email.setVisibility(View.VISIBLE);
            btn_home.setVisibility(View.VISIBLE);
            btn_share.setVisibility(View.VISIBLE);
            btn_help.setVisibility(View.VISIBLE);
        }else {
            open=true;
            btn_settings.startAnimation(rotate);
            btn_email.startAnimation(tran_out);
            btn_home.startAnimation(tran_out);
            btn_share.startAnimation(tran_out);
            btn_help.startAnimation(tran_out);

            btn_email.setVisibility(View.INVISIBLE);
            btn_home.setVisibility(View.INVISIBLE);
            btn_share.setVisibility(View.INVISIBLE);
            btn_help.setVisibility(View.INVISIBLE);
        }
    }
}
