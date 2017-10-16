package com.example.fatmaali.activity119;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    TextView txt,total_txt;
    EditText Etxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView)findViewById(R.id.textView_txt);
        total_txt=(TextView)findViewById(R.id.textView_txtTotal);
        Etxt=(EditText)findViewById(R.id.editText_search);
    }

    public void btn_txt(View view) {
        try {
            InputStream inputStream = getAssets().open("android.txt");
            InputStreamReader rd = new InputStreamReader(inputStream);
            BufferedReader bf = new BufferedReader(rd);
            try{
                String line;
                txt.setText("");
                while ((line= bf.readLine())!= null){
                    txt.append(line + "\n");
                }

            }catch (IOException e){}

        }catch (IOException e){}
        total_txt.setText("");
    }

    public void btn_search(View view) {
        int total =0;
        String wordSearch = Etxt.getText().toString().trim();
        String fullTxt = txt.getText().toString();
        String[] array = fullTxt.split(" ");
        String word;
        StringBuilder st = new StringBuilder();

        for(int i =0; i< array.length; i++){
            word=array[i];
            if(word.contains(wordSearch)){
                st.append("<b><font color=\"#ff0000\">"+ word.trim()+"</font></b>");
                total++;
            }else {
                st.append(word);
            }
            st.append("");
        }
        txt.setText(Html.fromHtml(""+st));
        total_txt.setText("total words:"+total);
    }
}
