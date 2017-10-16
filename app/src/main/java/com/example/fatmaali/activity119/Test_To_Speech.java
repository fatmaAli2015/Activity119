package com.example.fatmaali.activity119;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class Test_To_Speech extends AppCompatActivity  implements TextToSpeech.OnInitListener{
    TextToSpeech tts;
    EditText edtxt_speech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__to__speech);
        edtxt_speech= (EditText) findViewById(R.id.edtxt_speech);
        tts = new TextToSpeech(this,this);
    }

    public void btn_speech(View view) {
        tts.speak(edtxt_speech.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    public void onInit(int i) {
        if (i==TextToSpeech.SUCCESS){
            Locale locale= tts.getLanguage();
            int lan = tts.setLanguage(locale);
            if (lan==TextToSpeech.LANG_MISSING_DATA||lan==TextToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(this, "phone is not supported this language", Toast.LENGTH_SHORT).show();
            }
           
        }
    }
}
