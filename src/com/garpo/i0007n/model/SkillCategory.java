package com.garpo.i0007n.model;

/**
 * Created by Conny Garpö on 4/23/2016.
 */
public class SkillCategory {
    private int id;
    private String description;

    public SkillCategory(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
