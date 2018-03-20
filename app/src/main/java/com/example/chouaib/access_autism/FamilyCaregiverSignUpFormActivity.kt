package com.example.chouaib.access_autism

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FamilyCaregiverSignUpFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family_caregiver_sign_up_form)
    }

    fun onClickNext(v: View){
        val intent = Intent(this,AsdFeatures1_1::class.java)
        this.startActivity(intent)
    }
}
