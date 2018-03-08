package com.example.chouaib.access_autism

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView.CHOICE_MODE_MULTIPLE
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_asd_features2_8.*

class ActivityAsdFeatures2_8 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asd_features2_8)
        val adapter = ArrayAdapter.createFromResource(this,
                R.array.skills_titles, android.R.layout.simple_list_item_multiple_choice)
        listView.adapter =adapter
        listView.choiceMode = CHOICE_MODE_MULTIPLE
    }

    fun onClickNext(v: View) {
        var check=0
        val count = listView.count
        for (i in 0..count-1) {
            if (listView.isItemChecked(i))
                check += 1
        }
        if (check==3) {
            val intent = Intent(this, FamilyCaregiverSignUpForm3Activity::class.java)
            this.startActivity(intent)
        }
        else{
            textError.text="Please select 3 items"
        }
    }
}
