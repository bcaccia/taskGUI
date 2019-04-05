package com.caccia.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField inputSummary;

    @FXML
    private TextField inputPriority;

    @FXML
    private TextField inputContext;

    @FXML
    private Button addTask;

    @FXML
    private Tooltip addTaskTooltip;

    @FXML
    private Button removeTask;

    @FXML
    private Tooltip removeTaskTooltip;

    @FXML
    private TableView<Task> taskTable;

    @FXML
    private TableColumn<Task, String> summaryColumn;

    @FXML
    private TableColumn<Task, String> priorityColumn;

    @FXML
    private TableColumn<Task, String> contextColumn;

    @FXML
    private TableColumn<Task, String> createdColumn;

    @FXML
    void initialize() {

        summaryColumn.setCellValueFactory(new PropertyValueFactory<>("summary"));
        priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
        contextColumn.setCellValueFactory(new PropertyValueFactory<>("context"));
        createdColumn.setCellValueFactory(new PropertyValueFactory<>("creationTime"));

        taskTable.setItems(getTasks());

        addTask.setOnAction(e -> {
            if (!inputSummary.getText().equals("") && !inputPriority.getText().equals("") && !inputContext.getText().equals("")) {
                ObservableList<Task> data = taskTable.getItems();
                // Create a new task object and initialize with the data in the UI fields
                Task newTask = new Task();
                newTask.setSummary(inputSummary.getText());
                newTask.setPriority(inputPriority.getText());
                newTask.setContext(inputContext.getText());

                data.add(newTask);
            }

        });

    }

    //Get all of the products
    public ObservableList<Task> getTasks(){
        ObservableList<Task> tasks = FXCollections.observableArrayList();
        Task newTask = new Task();
        newTask.setSummary("hello");
        newTask.setPriority("1");
        newTask.setContext("office");
        tasks.add(newTask);
        return tasks;
    }

}
