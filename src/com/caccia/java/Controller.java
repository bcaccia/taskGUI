package com.caccia.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

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
    public void initialize(URL url, ResourceBundle resourceBundle) {

        summaryColumn.setCellValueFactory(new PropertyValueFactory<>("summary"));
        priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
        contextColumn.setCellValueFactory(new PropertyValueFactory<>("context"));
        createdColumn.setCellValueFactory(new PropertyValueFactory<>("creationTime"));


        taskTable.setItems(getTasks());


        addTask.setOnAction(e -> {
            if (!inputSummary.getText().equals("") && !inputPriority.getText().equals("") && !inputContext.getText().equals("")) {
                ObservableList<Task> data = taskTable.getItems();
                // Create a new task object and initialize with the data in the UI fields
                Task newTask = new Task(inputSummary.getText(), inputPriority.getText(), inputContext.getText());
                newTask.setSummary(inputSummary.getText());
                newTask.setPriority(inputPriority.getText());
                newTask.setContext(inputContext.getText());

                data.add(newTask);

//                Clear out the text fields
                inputSummary.setText("");
                inputPriority.setText("");
                inputContext.setText("");
            }

        });

    }

    public ObservableList<Task> getTasks() {
        ObservableList<Task> tasks = FXCollections.observableArrayList();
        Task newTask = new Task("hello", "1", "office");
        tasks.add(newTask);
        return tasks;
    }
}
