package com.example.chouaib.access_autism

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FamilyDashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family_dashboard)
    }

    fun onClickModules(view: View) {

        val intent = Intent(this, SkillsListActivity::class.java)
        startActivity(intent)
    }
}
