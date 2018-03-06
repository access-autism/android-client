package com.example.chouaib.access_autism;

/**
 * Created by chouaib on 3/6/18.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/***
 * The adapter class for the RecyclerView, contains the skills data
 */
class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.ViewHolder>  {

    //Member variables
    private ArrayList<Skill> mskillsData;
    private Context mContext;

    SkillsAdapter(Context context, ArrayList<Skill> skillsData) {
        this.mskillsData = skillsData;
        this.mContext = context;
    }

    @Override
    public SkillsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }
    
    @Override
    public void onBindViewHolder(SkillsAdapter.ViewHolder holder, int position) {
        //Get current skill
        Skill currentskill = mskillsData.get(position);
        //Populate the textviews with data
        holder.bindTo(currentskill);
    }
    
    @Override
    public int getItemCount() {
        return mskillsData.size();
    }
    
    class ViewHolder extends RecyclerView.ViewHolder {

        //Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mInfoText;
        
        ViewHolder(View itemView) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
        }

        void bindTo(Skill currentskill){
            //Populate the textviews with data
            mTitleText.setText(currentskill.getTitle());
            mInfoText.setText(currentskill.getInfo());

        }
    }
}
