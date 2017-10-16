package com.example.fatmaali.activity119;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class searchListView extends AppCompatActivity {
    TextView txtListTotal;
    EditText edtxtListSearch;
    ListView listSearch;

    ArrayList Alist = new ArrayList();
    ArrayList Alist_search = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list_view);
        txtListTotal = (TextView) findViewById(R.id.textView_listTotal);
        edtxtListSearch = (EditText) findViewById(R.id.editText_ListSearch);
        listSearch = (ListView) findViewById(R.id.listSearch);
    }

    public void btn_ListTxt(View view) {
        Alist.clear();
        try {
            InputStream input = getAssets().open("list.txt");
            InputStreamReader ISR = new InputStreamReader(input);
            BufferedReader BR = new BufferedReader(ISR);
            String line;
            while ((line = BR.readLine()) != null) {
                Alist.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, Alist);
        listSearch.setAdapter(arrayAdapter);
        txtListTotal.setText("total :" + Alist.size());
    }

    public void btn_ListSearch(View view) {
        Alist_search.clear();
        String item_search = edtxtListSearch.getText().toString().trim();
        for(int i = 0; i< Alist.size();i++){
            String item = Alist.get(i).toString();
            if(item.contains(item_search)){
                Alist_search.add(item);
            }
        }
        ArrayAdapter arrayAdapter2= new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,Alist_search);
        listSearch.setAdapter(arrayAdapter2);
        txtListTotal.setText("total:"+Alist_search.size());
    }
}
