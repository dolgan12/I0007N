package com.garpo.i0007n;

import com.garpo.i0007n.controll.Controller;
import com.garpo.i0007n.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Conny Garpö on 4/24/2016.
 */
public class TestDB {
    public static void main(String[] args){
        System.out.println("Starting DB Test!\n");

        Controller controller = Controller.getController();

        List<Person> persons = null;
        try {
            persons = controller.getPersons();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(Person person : persons){
            System.out.println(person.getId() + " " + person);
        }


        List<SkillCategory> skills = new ArrayList<>();

        try {
            skills = controller.getSkills(2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(SkillCategory skill : skills){
            System.out.println(skill.getDescription());
        }

        try {
            System.out.println(controller.getPerson(1));
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("\nDone!!");

    }
}
