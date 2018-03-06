package com.example.chouaib.access_autism;

/**
 * Created by chouaib on 3/6/18.
 */

/**
 * Data model for each row of the Skills RecyclerView.
 */
class Skill {

    //Member variables representing the title and information about the skill
    private String title;
    private String info;

    Skill(String title, String info) {
        this.title = title;
        this.info = info;
    }

    String getTitle() {
        return title;
    }

    String getInfo() {
        return info;
    }
}
