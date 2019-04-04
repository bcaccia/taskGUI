package com.caccia.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    public ObservableList<Task> getTask() {
        ObservableList<Task> tasks = FXCollections.observableArrayList();
        tasks.add(new Task("here is the summary", "1", "office"));
        return tasks;
    }

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
    private TableView<?> taskTable;

    @FXML
    private TableColumn<?, ?> summaryColumn;

    @FXML
    private TableColumn<?, ?> priorityColumn;

    @FXML
    private TableColumn<?, ?> contextColumn;

    @FXML
    void initialize() {


        addTask.setOnAction(e -> {
            if (!inputSummary.getText().equals("") && !inputPriority.getText().equals("") && !inputContext.getText().equals("")) {
                System.out.println(inputSummary.getText());
            }

        });

    }

}
