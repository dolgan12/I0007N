package com.garpo.i0007n.view.beans;

import com.garpo.i0007n.controll.Controller;
import com.garpo.i0007n.model.Person;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Conny Garpö on 2016-05-16.
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    //@Resource(name="jdbc/mysqldb")

    private String logedInPerson;
    private List<String> listOfPersons;
    private List<Person> persons;
    private Controller controller;

    public LoginBean() {
        try {
            controller = Controller.getController();
            persons = controller.getPersons();

        } catch (Exception e) {
            e.printStackTrace();
        }
        listOfPersons =  new ArrayList<>();
    }
    public void loadPersons(){
        listOfPersons.clear();
        for(Person person : persons){
            listOfPersons.add(person.toString());
        }
    }

    public void setLogedInPerson(String logedInPerson) {
        this.logedInPerson = logedInPerson;
    }

    public List<String> getListOfPersons() {
        return listOfPersons;
    }

    public String getLogedInPerson() {
        return logedInPerson;
    }

}
