package com.example.chouaib.access_autism

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView.CHOICE_MODE_MULTIPLE
import kotlinx.android.synthetic.main.activity_asd_features2_6_1.*

class ActivityAsdFeatures2_6_1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asd_features2_6_1)
        val adapter = ArrayAdapter.createFromResource(this,
                R.array.play_multiple_choices, android.R.layout.simple_list_item_multiple_choice)
        listView.adapter =adapter
        listView.choiceMode = CHOICE_MODE_MULTIPLE
    }


    fun onClickNext(v: View) {
        //count the number of item selected
        var check=0
        val count = listView.count
        for (i in 0..count-1) {
            if (listView.isItemChecked(i))
                check += 1
        }
        if (check!=0) {
            val intent = Intent(this, ActivityAsdFeatures2_7::class.java)
            this.startActivity(intent)
        }
        else{
            textError.text = "Please select an item"

        }

    }

}
