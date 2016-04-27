package com.garpo.i0007n.model;

/**
 * Created by Conny Garpö on 4/24/2016.
 */
public class Status {
    private int id;
    private String description;
    public Status(int id, String description) {
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
