package com.example.chouaib.access_autism

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_asd_features2_2.*

class ActivityAsdFeatures2_2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asd_features2_2)
    }


    fun onClickNext (v: View){
        //if one button have been selected (yes or no)
        if(radioGroup1.checkedRadioButtonId!=-1 && radioGroup2.checkedRadioButtonId!=-1 && radioGroup3.checkedRadioButtonId!=-1 && radioGroup4.checkedRadioButtonId!=-1){
            val intent = Intent(this, ActivityAsdFeatures2_3::class.java)
            this.startActivity(intent)
        }
        else {
            textError.text = "Please select an item"
        }

    }
}
