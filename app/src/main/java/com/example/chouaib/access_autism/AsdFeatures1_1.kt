package com.example.chouaib.access_autism

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AsdFeatures1_1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asd_features1_1)
    }

    fun onClickNext(v: View){
        val intent = Intent(this, AsdFeatures1_2::class.java)
        this.startActivity(intent)
    }
}
