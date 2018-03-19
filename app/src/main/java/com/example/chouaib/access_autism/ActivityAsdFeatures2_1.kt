package com.example.chouaib.access_autism

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_asd_features2_1.*

class ActivityAsdFeatures2_1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asd_features2_1)

       // val number= findViewById<NumberPicker>(R.id.numberPicker4);
        numberPicker4.minValue=0
        numberPicker4.maxValue=36
        numberPicker5.minValue=0
        numberPicker5.maxValue=36
        numberPicker7.minValue=0
        numberPicker7.maxValue=36


    }


    fun onClickNext(v: View){
        if((numberPicker4.value!=0 || radioButton3.isChecked) &&(numberPicker5.value!=0 || radioButton4.isChecked)&& (numberPicker7.value!=0 || radioButton5.isChecked )) {
            val intent = Intent(this, ActivityAsdFeatures2_2::class.java)
            this.startActivity(intent)
        }
        else{
            textError.text = "Select an answer"
        }
    }
}

