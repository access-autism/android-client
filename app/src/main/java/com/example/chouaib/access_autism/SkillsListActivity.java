package com.example.chouaib.access_autism;

/**
 * Created by chouaib on 3/6/18.
 */

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

/***
 * Main Activity for the Material Me app, a mock Skills news application
 */
public class SkillsListActivity extends AppCompatActivity {

    //Member variables
    private RecyclerView mRecyclerView;
    private ArrayList<Skill> mSkillsData;
    private SkillsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills_list);

        setTitle("Access-autism - SKILLS");

        //Initialize the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        //Set the Layout Manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //Initialize the ArrayList that will contain the data
        mSkillsData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new SkillsAdapter(this, mSkillsData);
        mRecyclerView.setAdapter(mAdapter);

        //Get the data
        initializeData();

        //Helper class for creating swipe to dismiss and drag and drop functionality
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback
                (ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN
                        | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            /**
             * Method that defines the drag and drop functionality
             * @param recyclerView The RecyclerView that contains the list items
             * @param viewHolder The SkillsViewHolder that is being moved
             * @param target The SkillsViewHolder that you are switching the original one with.
             * @return returns true if the item was moved, false otherwise
             */
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {

                //Get the from and to position
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                //Swap the items and notify the adapter
                Collections.swap(mSkillsData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            /**
             * Method that defines the swipe to dismiss functionality
             * @param viewHolder The viewholder being swiped
             * @param direction The direction it is swiped in
             */
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                //Remove the item from the dataset
                mSkillsData.remove(viewHolder.getAdapterPosition());

                //Notify the adapter
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        //Attach the helper to the RecyclerView
        helper.attachToRecyclerView(mRecyclerView);
    }

    /**
     * Method for initializing the Skills data from resources.
     */
    private void initializeData() {
        //Get the resources from the XML file
        String[] SkillsList = getResources().getStringArray(R.array.skills_titles);
        String[] SkillsInfo = getResources().getStringArray(R.array.skills_info);
        TypedArray SkillsImageResources = getResources().obtainTypedArray(R.array.skills_images);
        //Clear the existing data (to avoid duplication)
        mSkillsData.clear();


        //Create the ArrayList of Skills objects with the titles, images
        // and information about each Skill
        for(int i=0; i<SkillsList.length; i++){
            mSkillsData.add(new Skill(SkillsList[i], SkillsInfo[i],
                    SkillsImageResources.getResourceId(i,0)));
        }

        //Recycle the typed array
        SkillsImageResources.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }

    /**
     * onClick method for th FAB that resets the data
     * @param view The button view that was clicked
     */
    public void resetSkills(View view) {
        initializeData();
    }
}
