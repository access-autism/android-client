package com.example.chouaib.access_autism

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FamilyCaregiverSignUpForm3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family_caregiver_sign_up_form3)
    }

    fun onClickNext(v: View){
        //Dashboard
        val intent = Intent(this, FamilyDashboard::class.java)
        this.startActivity(intent)
    }
}
