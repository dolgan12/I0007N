package com.garpo.i0007n.controll;

import com.garpo.i0007n.model.*;
import com.garpo.i0007n.view.MainFrame;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Conny Garpö on 4/23/2016.
 *  Singelton class.
 */
public class Controller {
    private static Controller controller = new Controller();
    List<Status> statuses = new ArrayList<>();
    List<SkillCategory> skills = new ArrayList<>();
    List<Person> persons = new ArrayList<>();
    List<Category> categories = new ArrayList<>();

    PersonDAO personDAO = new MySQLPersonDAO();
    TaskDAO taskDAO = new MySQLTaskDAO();
    StatusDAO statusDAO = new MySQLStatusDAO();
    CategoryDAO categoryDAO = new MySQLCategoryDAO();


    private Controller() {
        try {
            statuses = statusDAO.getAllStatus();
            persons = personDAO.getAllPersons();
            categories = categoryDAO.getAllCategories();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static Controller getController(){
        return controller;
    }

    public void closeDb() throws SQLException{
        MySQLDatabase.getInstance().disconnect();
    }



    /**
     *  =======  Person Controlls ===========
     */

    public List<Person> getPersons(){
        return persons;
    }

    public List<SkillCategory> getSkills(int id) throws Exception{
        List<SkillCategory> skills = personDAO.getPersonSkills(id);

        return skills;
    }

    public Person getPerson(int id){
        Person person = persons.get(id-1);

        return person;
    }


    /**
     *
     * =========  Task Controlls  ===========
     */
    public int  addTask(Task task) throws Exception{
        return taskDAO.addTask(task);
    }
    public List<Task> getTasks() throws Exception{
        return taskDAO.getAllTasks();
    }



    /**
     *  === Status Controlls  =====
     */

    public List<Status> getStatuses() {
        return statuses;
    }
    public Status getStatus(int id){
        return statuses.get(id);
    }
    public List<String> getStatusList(){
        List<String> statusList = new ArrayList<>();
        for(Status status : statuses){
            statusList.add(status.getDescription());
        }
        return statusList;
    }


    /**
     *  ===== Category Controlls ======
     */
    public List<Category> getCategories(){return categories;}
    public Category getCategory(int id){return categories.get(id-1);}
    public List<String> getCategoryList(){
        List<String> categoryList = new ArrayList<>();
        for(Category category : categories){
            categoryList.add(category.getDescription());
        }
        return categoryList;
    }


}
