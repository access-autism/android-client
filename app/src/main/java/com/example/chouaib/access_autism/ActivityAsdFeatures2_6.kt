package com.example.chouaib.access_autism

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_asd_features2_6.*

class ActivityAsdFeatures2_6 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asd_features2_6)
    }



    fun onClickNext(v: View) {
        if (radioButton.isChecked) {
            val intent = Intent(this, ActivityAsdFeatures2_6_1::class.java)
            this.startActivity(intent)
        } else {
            if (radioButton2.isChecked) {
                val intent = Intent(this, ActivityAsdFeatures2_7::class.java)
                this.startActivity(intent)
            } else {
                textError.text = "Please select an item"
            }
        }
    }
}
