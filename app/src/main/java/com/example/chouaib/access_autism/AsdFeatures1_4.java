package com.example.chouaib.access_autism;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class AsdFeatures1_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asd_features1_4);

        CheckBox item1 = findViewById(R.id.item1);

        item1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    findViewById(R.id.item1_yes).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.item1_yes).setVisibility(View.GONE);
                }
            }
        });
    }

    public void onClickNext(View view) {

        Intent intent = new Intent(this, ActivityAsdFeatures2_1.class);
        startActivity(intent);
    }
}
