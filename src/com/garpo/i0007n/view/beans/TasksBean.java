package com.garpo.i0007n.view.beans;

import com.garpo.i0007n.controll.Controller;
import com.garpo.i0007n.model.Comment;
import com.garpo.i0007n.model.Status;
import com.garpo.i0007n.model.Task;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
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
    private String assigned;
    private String newComment;
    private Task task;
    private List<Status> statuses;
    private int id;


    public TasksBean() {
        controller = Controller.getController();
    }

    @PostConstruct
    public void init() {
        try {
            tasks = controller.getTasksForPerson(getLogedInPersonId());
            statuses = controller.getStatuses();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insert(Task task){
        if(task != null)
            this.task = task;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public String getNewComment() {
        return newComment;
    }

    public void setNewComment(String newComment) {
        this.newComment = newComment;
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

    public String getTaskStatus(int statusId){
        return controller.getStatus(statusId).getDescription();
    }

    public String getTaskCategory(int taskId){
        return controller.getCategory(taskId).getDescription();
    }

    public List<String> getStatusList(){
        return controller.getStatusList();
    }

    public List<Comment> getCommentsForTask(int taskId){
        List<Comment> comments = null;
        try {
            comments = controller.getComments(taskId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    public String getname(int personId){
        return controller.getPerson(personId).toString();
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }


    public void saveItem(){
        try {
            int assignedTo = controller.getPersonId(logedInPerson);
            if(!newComment.equals("") && newComment != null){
                int commentId = controller.getNextCommentId();
                Comment comment = new Comment(commentId,assignedTo, task.getId(), newComment, Calendar.getInstance().getTime());
                controller.addComment(comment);
            }

            controller.updateTask(task);
        } catch (Exception e) {
            e.printStackTrace();
        }
        newComment = null;

    }



}
