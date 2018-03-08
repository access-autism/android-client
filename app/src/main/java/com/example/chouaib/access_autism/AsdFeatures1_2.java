package com.example.chouaib.access_autism;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class AsdFeatures1_2 extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asd_features1_2);

        final CheckBox checkbox1 = findViewById(R.id.checkBox);
        final CheckBox checkbox2 = findViewById(R.id.checkBox2);
        final CheckBox checkbox3 = findViewById(R.id.checkBox3);

        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkbox2.setChecked(false);
                    checkbox3.setChecked(false);
                    findViewById(R.id.daycareName).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.daycareName).setVisibility(View.GONE);
                }
            }
        });


        checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkbox1.setChecked(false);
                    checkbox3.setChecked(false);
                    findViewById(R.id.schoolName).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.schoolName).setVisibility(View.GONE);
                }
            }
        });


        checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkbox2.setChecked(false);
                    checkbox1.setChecked(false);
                    findViewById(R.id.otherName).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.otherName).setVisibility(View.GONE);
                }
            }
        });

    }

    public void onClickNext(View view) {
        Intent intent = new Intent(this, AsdFeatures1_3.class);
        startActivity(intent);
    }

    //Add code to select list items + visual feedback
}
