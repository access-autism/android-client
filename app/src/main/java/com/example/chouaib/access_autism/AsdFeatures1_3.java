package com.example.chouaib.access_autism;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
import android.widget.SimpleExpandableListAdapter;

public class AsdFeatures1_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asd_features1_3);

        RadioButton radio1 = findViewById(R.id.radioButton1);

        radio1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //findViewById(R.id.concernsList).setVisibility(View.VISIBLE);
                    findViewById(R.id.expviewPlaceholder).setVisibility(View.VISIBLE);
                } else {
                    //findViewById(R.id.concernsList).setVisibility(View.GONE);
                    findViewById(R.id.expviewPlaceholder).setVisibility(View.GONE);
                }
            }
        });

        /*
        Expandable list adapter here

        ExpandableListView elv = findViewById(R.id.concernsList);
        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(...); (xml has to be changed)

        elv.setAdapter(adapter);

        */
    }

    public void onClickNext(View view) {
        Intent intent = new Intent(this, AsdFeatures1_4.class);
        startActivity(intent);
    }

}
