package com.example.chouaib.access_autism

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent



class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    fun onClickSignUp(v: View){
        val intent = Intent(this, SignUpActivity::class.java)
        this.startActivity(intent)
    }

    fun onClickLogin(v: View){
        val intent = Intent(this, SkillsListActivity::class.java )
        this.startActivity(intent)
    }
}
