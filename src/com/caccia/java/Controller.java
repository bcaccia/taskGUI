package com.caccia.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private static final String FILENAME = "taskList.csv";
    private ObservableList<Task> data = FXCollections.observableArrayList();

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

        readFromFile();

        summaryColumn.setCellValueFactory(new PropertyValueFactory<>("summary"));
        priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
        contextColumn.setCellValueFactory(new PropertyValueFactory<>("context"));
        createdColumn.setCellValueFactory(new PropertyValueFactory<>("creationTime"));


        taskTable.setItems(data);


//        Add a task when + is clicked in the UI
        addTask.setOnAction(e -> {
            if (!inputSummary.getText().equals("") && !inputPriority.getText().equals("") && !inputContext.getText().equals("")) {
                data = taskTable.getItems();
                // Create a new task object and initialize with the data in the UI fields
                Task newTask = new Task(inputSummary.getText(), inputPriority.getText(), inputContext.getText());
                newTask.setSummary(inputSummary.getText());
                newTask.setPriority(inputPriority.getText());
                newTask.setContext(inputContext.getText());

                data.add(newTask);
                writeToFile();

//                Clear out the text fields
                inputSummary.setText("");
                inputPriority.setText("");
                inputContext.setText("");
            }

        });

//        Remove a task when - is clicked in the UI
        removeTask.setOnAction(e -> {
            Task selectedItem = taskTable.getSelectionModel().getSelectedItem();
            taskTable.getItems().remove(selectedItem);
            writeToFile();
        });

    }

    private ObservableList<Task> getTasks() {
        ObservableList<Task> tasks = FXCollections.observableArrayList();
        Task newTask = new Task("hello", "1", "office");
        tasks.add(newTask);
        return tasks;
    }

    /**
     * Write the taskList to a .csv tab delimited format file
     */
    private void writeToFile() {
        BufferedWriter bw = null;
        FileWriter fw = null;
        final ArrayList<Task> taskList = new ArrayList<>(data);

        try {
            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);

            for (Task x :
                    taskList) {
                bw.write(x.getSummary() + "\t"
                        + x.getPriority() + "\t"
                        + x.getContext() + "\t"
                        + x.getCreationTime() + "\n");
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readFromFile() {
        BufferedReader br = null;
        File f = new File(".", FILENAME);
        String line;
        String splitBy = "\t";

        // Check if the file exists first. If it doesn't, continue on with the execution of the program.
        if (f.exists()) {
            try {

                br = new BufferedReader(new FileReader(FILENAME));


                while ((line = br.readLine()) != null) {

                    String[] rawTasks = line.split(splitBy);
                    Task tempTask = new Task(rawTasks[0], rawTasks[1], rawTasks[2], rawTasks[3]);
                    data.add(tempTask);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
