package com.garpo.i0007n.model;

import java.util.List;

/**
 * Created by Conny Garpö on 4/24/2016.
 */
public interface TaskDAO {
    int addTask(Task task) throws Exception;
    int updateTask(Task task) throws Exception;
    List<Task> getAllTasks() throws Exception;
    Task getTask(int id) throws Exception;
}
