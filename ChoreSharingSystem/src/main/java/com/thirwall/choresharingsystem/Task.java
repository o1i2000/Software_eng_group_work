/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thirwall.choresharingsystem;

import java.time.DayOfWeek;
import java.time.Instant;

/**
 *
 * @author thura
 */
public class Task {
    /* Fields */
    private int id;
    
    private String name;
    
    private boolean oneOff;
    
    private DayOfWeek weekday;
    
    private User assignedTo;
    
    private Instant completedOn;

    /* Getters & Setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOneOff() {
        return oneOff;
    }

    public void setOneOff(boolean oneOff) {
        this.oneOff = oneOff;
    }

    public DayOfWeek getWeekday() {
        return weekday;
    }
    
    public int getWeekdayInt() {
        return weekday.getValue();
    }

    public void setWeekday(Integer weekday) {
        if (weekday != 0 && weekday != null) {
            this.weekday = DayOfWeek.of(weekday);   
        }
    }
    
    public User getAssignedTo() {
        return assignedTo;
    }
    
    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Instant getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(String completedDate) {
        if (completedDate != null) {
            this.completedOn = Instant.parse(completedDate);
        }
    }
    
    public boolean getIsCompleted() {
        return this.completedOn != null;
    }
    
    public static class History extends Task {
        
        /* Fields */
        private User wasAssignedTo;
        
        private Instant wasCompletedOn;
        
        /* Getters & Setters */
        public User getWasAssignedTo() {
            return this.wasAssignedTo;
        }
        
        public void setWasAssignedTo(User user) {
            this.wasAssignedTo = user;
        }
        
        public Instant getWasCompletedOn() {
            return wasCompletedOn;
        }
        
        public void setWasCompletedOn(String completedDate) {
            if (completedDate != null) {
                this.wasCompletedOn = Instant.parse(completedDate);
            }
        }
        
        public boolean getWasCompleted() {
            return this.wasCompletedOn != null;
        }
    }
    
    /* Methods */
    @Override
    public String toString() {
        return this.name;
    }
}
