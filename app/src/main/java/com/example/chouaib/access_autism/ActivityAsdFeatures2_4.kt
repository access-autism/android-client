package com.example.chouaib.access_autism

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ActivityAsdFeatures2_4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asd_features2_4)
    }

    fun onClickNext(v: View){
        val intent = Intent(this, ActivityAsdFeatures2_5::class.java)
        this.startActivity(intent)
    }
}
