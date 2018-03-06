package com.example.chouaib.access_autism;

/**
 * Created by chouaib on 3/6/18.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/***
 * The adapter class for the RecyclerView, contains the skills data
 */
class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.SkillsViewHolder>  {

    //Member variables
    private GradientDrawable mGradientDrawable;
    private ArrayList<Skill> mSkillsData;
    private Context mContext;

    SkillsAdapter(Context context, ArrayList<Skill> SkillsData) {
        this.mSkillsData = SkillsData;
        this.mContext = context;

        //Prepare gray placeholder
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //Make the placeholder same size as the images
        Drawable drawable = ContextCompat.getDrawable
                (mContext,R.drawable.img_badminton);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    @Override
    public SkillsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SkillsViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(SkillsViewHolder holder, int position) {

        //Get the current Skill
        Skill currentSkill = mSkillsData.get(position);

        //Bind the data to the views
        holder.bindTo(currentSkill);

    }

    @Override
    public int getItemCount() {
        return mSkillsData.size();
    }

    static class SkillsViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        //Member Variables for the holder data
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mSkillsImage;
        private Context mContext;
        private Skill mCurrentSkill;
        private GradientDrawable mGradientDrawable;

        SkillsViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
            mSkillsImage = (ImageView)itemView.findViewById(R.id.skillsImage);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            //Set the OnClickListener to the whole view
            itemView.setOnClickListener(this);
        }

        void bindTo(Skill currentSkill){
            //Populate the textviews with data
            mTitleText.setText(currentSkill.getTitle());
            mInfoText.setText(currentSkill.getInfo());

            //Get the current Skill
            mCurrentSkill = currentSkill;



            //Load the images into the ImageView using the Glide library
            Glide.with(mContext).load(currentSkill.
                    getImageResource()).placeholder(mGradientDrawable).into(mSkillsImage);
        }

        @Override
        public void onClick(View view) {

            //Set up the detail intent
            Intent detailIntent = Skill.starter(mContext, mCurrentSkill.getTitle(),
                    mCurrentSkill.getImageResource());


            //Start the detail activity
            mContext.startActivity(detailIntent);
        }
    }
}
