package com.garpo.i0007n.controll;

import com.garpo.i0007n.model.Person;

import java.util.EventObject;

/**
 * Created by Conny Garpö on 4/25/2016.
 */
public class FormEvent extends EventObject{

    private int id;
    private Person assignedTo;
    private String category;
    private String status;
    private String description;
    private int estimateTime;
    private int usedTime;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, int id, Person assignedTo, String category, String status, String description, int estimateTime, int usedTime){
        super(source);

        this.id = id;
        this.assignedTo = assignedTo;
        this.category = category;
        this.status = status;
        this.description = description;
        this.estimateTime = estimateTime;
        this.usedTime = usedTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Person assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatusId() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEstimateTime() {
        return estimateTime;
    }

    public void setEstimateTime(int estimateTime) {
        this.estimateTime = estimateTime;
    }

    public int getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(int usedTime) {
        this.usedTime = usedTime;
    }
}
