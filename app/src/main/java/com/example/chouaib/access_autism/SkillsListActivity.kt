package com.example.chouaib.access_autism

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import java.util.ArrayList

class SkillsListActivity : AppCompatActivity() {

    //Member variables
    private var mRecyclerView: RecyclerView? = null
    private var mSkillsData: ArrayList<Skill>? = null
    private var mAdapter: SkillsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skills_list)
        supportActionBar?.title = "Access-autism  -  SKILLS"

        //Initialize the RecyclerView
        mRecyclerView = findViewById(R.id.recyclerView) as RecyclerView

        //Set the Layout Manager
        mRecyclerView!!.setLayoutManager(LinearLayoutManager(this))

        //Initialize the ArrayLIst that will contain the data
        mSkillsData = ArrayList<Skill>()

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = SkillsAdapter(this, mSkillsData)
        mRecyclerView!!.setAdapter(mAdapter)

        //Get the data
        initializeData()
    }

    /**
     * Method for initializing the Skills data from resources.
     */
    private fun initializeData() {
        //Get the resources from the XML file
        val SkillsList = resources.getStringArray(R.array.skills_titles)
        val SkillsInfo = resources.getStringArray(R.array.skills_info)

        //Clear the existing data (to avoid duplication)
        mSkillsData!!.clear()

        //Create the ArrayList of Skills objects with the titles and information about each Skill
        for (i in SkillsList.indices) {
            mSkillsData!!.add(Skill(SkillsList[i], SkillsInfo[i]))
        }

        //Notify the adapter of the change
        mAdapter!!.notifyDataSetChanged()
    }
}
