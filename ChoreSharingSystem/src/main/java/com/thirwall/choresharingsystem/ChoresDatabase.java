/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thirwall.choresharingsystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thura
 */
public class ChoresDatabase {
    private final DBConnection database;
    
    public ChoresDatabase() {
        database = new DBConnection();
        database.Connect("/Users/thura/projects/java_apps/Software_eng_group_work/chores.db");
    } // Database Constructor
    
    public User getUser(int userId) {
        String sqlString = "SELECT id, name, remaining_load FROM users WHERE id = " + userId + ";";
        ResultSet userResult = database.RunSQLQuery(sqlString);
        
        User user = new User();
        
        try {
            while (userResult.next()) {
                user.setId(userResult.getInt(1));
                user.setName(userResult.getString(2));
                user.setRemainingLoad(userResult.getFloat(3));
            }
            return user;
        }
        catch (SQLException ex) {
            return user;
        }
    }
    
    public ArrayList<User> getUsers() {
        String sqlString = "SELECT id, name, remaining_load FROM users;";
        ResultSet userResult = database.RunSQLQuery(sqlString);
        
        ArrayList<User> users = new ArrayList<>();
        
        try {
            while (userResult.next()) {
                User user = new User();
                user.setId(userResult.getInt(1));
                user.setName(userResult.getString(2));
                user.setRemainingLoad(userResult.getFloat(3));
                
                users.add(user);
            }
            return users;
        }
        catch (SQLException ex) {
            return users;
        }
    }
    
    public ArrayList<Task> getCommonTasks() {
        User user1 = getUser(1);
        User user2 = getUser(2);
        
        String sqlString = "SELECT id, name, one_off, weekday, completed_on, assigned_to FROM tasks WHERE one_off = 0;";
        ResultSet taskResult = database.RunSQLQuery(sqlString);
        
        ArrayList<Task> tasks = new ArrayList<>();
        
        try {
            while (taskResult.next()) {
                Task task = new Task();
                task.setId(taskResult.getInt(1));
                task.setName(taskResult.getString(2));
                task.setOneOff(taskResult.getBoolean(3));
                task.setWeekday(taskResult.getInt(4));
                task.setCompletedOn(taskResult.getString(5));
                
                int userId = taskResult.getInt(6);
                if (userId != 0) {
                    task.setAssignedTo(userId == 1 ? user1 : user2);
                }
                
                tasks.add(task);
            }
            return tasks;
        }
        catch(SQLException ex) {
            return tasks;
        }
    }
    
    public ArrayList<Task> getAssignedTasks(int userId) {
        User user = getUser(userId);
        
        String sqlString = "SELECT id, name, one_off, weekday, completed_on FROM tasks WHERE assigned_to = " + userId + ";";
        ResultSet taskResult = database.RunSQLQuery(sqlString);
        
        ArrayList<Task> tasks = new ArrayList<>();
        
        try {
            while (taskResult.next()) {
                Task task = new Task();
                task.setId(taskResult.getInt(1));
                task.setName(taskResult.getString(2));
                task.setOneOff(taskResult.getBoolean(3));
                task.setWeekday(taskResult.getInt(4));
                task.setCompletedOn(taskResult.getString(5));
                task.setAssignedTo(user);
                
                tasks.add(task);
            }
            return tasks;
        }
        catch(SQLException ex) {
            return tasks;
        }
    }
    
    public ArrayList<Task.History> getTaskHistory() {
        User user1 = getUser(1);
        User user2 = getUser(2);
        
        String sqlString = "SELECT tasks.id, tasks.name, one_off, weekday, tasks.completed_on, task_history.completed_on, user_id "
                + "FROM task_history INNER JOIN tasks ON tasks.id = task_history.task_id;";
        ResultSet taskResult = database.RunSQLQuery(sqlString);
        
        ArrayList<Task.History> tasks = new ArrayList<>();
        
        try {
            while (taskResult.next()) {
                Task.History task = new Task.History();
                task.setId(taskResult.getInt(1));
                task.setName(taskResult.getString(2));
                task.setOneOff(taskResult.getBoolean(3));
                task.setWeekday(taskResult.getInt(4));
                task.setCompletedOn(taskResult.getString(5));
                task.setWasCompletedOn(taskResult.getString(6));
                
                int userId = taskResult.getInt(7);
                if (userId != 0) {
                    task.setAssignedTo(userId == 1 ? user1 : user2);
                }
                
                tasks.add(task);
            }
            return tasks;
        }
        catch(SQLException ex) {
            return tasks;
        }
    }
}
