package com.example.chouaib.access_autism;

/**
 * Created by chouaib on 3/6/18.
 */

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Data model for each row of the Skills RecyclerView.
 */
class Skill {

    //Member variables representing the title, image and information about the Skill
    private final String title;
    private final String info;
    private final int imageResource;

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "Image Resource";


    Skill(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    String getTitle() {
        return title;
    }

    String getInfo() {
        return info;
    }

    int getImageResource() {
        return imageResource;
    }

    static Intent starter(Context context, String title, @DrawableRes int imageResId) {
        Intent detailIntent = new Intent(context, SkillDetailActivity.class);
        detailIntent.putExtra(TITLE_KEY, title);
        detailIntent.putExtra(IMAGE_KEY, imageResId);
        return detailIntent;
    }
}
