package com.garpo.i0007n.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Conny Garpö on 4/23/2016.
 */
public class Person {
    private static int count = 1;
    private int id;
    private String fname;
    private String ename;
    private List<SkillCategory> skills;

    public Person(String fname, String ename, List<SkillCategory> skills) {
        this.fname = fname;
        this.ename = ename;
        this.skills = skills;
        this.id = count;
        count++;
    }

    public Person(int id, String fname ,String ename, List<SkillCategory> skills) {
        this(fname, ename,skills);
        this.id = id;
    }
    public Person(String fname){
        this.fname = fname;
        this.ename = "";
        this.skills = new ArrayList<>();
        this.id = count;
        count++;
    }


    public List<SkillCategory> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillCategory> skills) {
        this.skills = skills;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return fname + " " + ename;
    }
}
