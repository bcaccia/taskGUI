package com.caccia.java;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class defines the data structure of a task object. It is to be instantiated
 * and used within the TaskFactory class.
 */
class Task {

    private SimpleStringProperty summary;
    private SimpleStringProperty priority;
    private SimpleStringProperty context;
    private SimpleStringProperty creationTime;

    /**
     * This constructor is used when the program is running and creates a new task
     * @param summary  Contains the full task summary text String
     * @param priority Contains a numerical String value of between 1-3
     * @param context  Contains a String context where the task will be executed.
     */
    public Task(SimpleStringProperty summary, SimpleStringProperty priority, SimpleStringProperty context) {
        this.summary = summary;
        this.priority = priority;
        this.context = context;
        LocalDateTime localTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.creationTime = new SimpleStringProperty(localTime.format(formatter));
    }

    /**
     * This constructor takes 4 arguments and is used when loading data back from a file so that
     * the timestamp is maintained and not replaced.
     *
     * @param summary      Contains the full task summary text String
     * @param priority     Contains a numerical String value of between 1-3
     * @param context      Contains a String context where the task will be executed.
     * @param creationTime Accepts a String from the save file with the date/time which
     *                     overrides creation time stamping.
     */
    public Task(SimpleStringProperty summary, SimpleStringProperty priority, SimpleStringProperty context, SimpleStringProperty creationTime) {
        this.summary = summary;
        this.priority = priority;
        this.context = context;
        this.creationTime = creationTime;
    }

    public Task() {
    }

    public String getSummary() {
        return summary.get();
    }

    public SimpleStringProperty summaryProperty() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary.set(summary);
    }

    public String getPriority() {
        return priority.get();
    }

    public SimpleStringProperty priorityProperty() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority.set(priority);
    }

    public String getContext() {
        return context.get();
    }

    public SimpleStringProperty contextProperty() {
        return context;
    }

    public void setContext(String context) {
        this.context.set(context);
    }

    public String getCreationTime() {
        return creationTime.get();
    }

    public SimpleStringProperty creationTimeProperty() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime.set(creationTime);
    }
}

