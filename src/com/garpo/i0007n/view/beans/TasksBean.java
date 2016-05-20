package com.garpo.i0007n.view.beans;

import com.garpo.i0007n.controll.Controller;
import com.garpo.i0007n.model.Task;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.List;

/**
 * Created by Conny Garpö on 2016-05-17.
 */
@ManagedBean
@SessionScoped
public class TasksBean {

    private Controller controller;
    private List<Task> tasks;
    @ManagedProperty("#{loginBean.logedInPerson}")
    private String logedInPerson;

    public TasksBean() {
        controller = Controller.getController();
    }

    @PostConstruct
    public void init() {
        try {
            tasks = controller.getTasksForPerson(getLogedInPersonId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLogedInPerson(String logedInPerson) {
        this.logedInPerson = logedInPerson;
    }

    public void setLogedInPersonId(String logedInPerson) {
        this.logedInPerson = logedInPerson;
    }

    public int getLogedInPersonId() {
        return controller.getPersonId(logedInPerson);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getTaskStatus(int taskId){
        return controller.getStatus(taskId).getDescription();
    }


}
