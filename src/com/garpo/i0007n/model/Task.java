package com.garpo.i0007n.model;

/**
 * Created by Conny Garpö on 4/24/2016.
 */
public class Task {
    private static int count = 1;
    private int id;
    private int assigned;
    private int category;
    private int status;
    private String description;
    private int estimateTime;
    private int usedTime;

    public Task(int assigned, int category, String description, int estimateTime) {
        this.id = count;
        this.assigned = assigned;
        this.category = category;
        this.status = 1;
        this.description = description;
        this.estimateTime = estimateTime;
        this.usedTime = 0;
        count++;
    }

    public Task(int id, int assigned, int category, int status, String description, int estimateTime, int usedTime) {
        this.id = id;
        this.assigned = assigned;
        this.category = category;
        this.status = status;
        this.description = description;
        this.estimateTime = estimateTime;
        this.usedTime = usedTime;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Task.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssigned() {
        return assigned;
    }

    public void setAssigned(int assigned) {
        this.assigned = assigned;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    @Override
    public String toString() {
        return "Id: " + id + "\nAssigned: " + assigned + "\nCategory: " + category + "\n" +
                "Status: " + status + "\nDescription: " + description + "\nEstimateTime: " + estimateTime + "\n" +
                "UsedTime: " + usedTime;
    }
}
