package com.training.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.Window;

public class demo implements EntryPoint {
    private TaskService taskService = new TaskService();
    private FlexTable taskTable = new FlexTable();

    public void onModuleLoad() {
        loadTasks();
        setupUI();
    }

    private void loadTasks() {
        taskTable.setText(0, 0, "Task Description");
        taskTable.setText(0, 1, "Status");
        taskTable.setText(0, 2, "Actions");

        for (Task task : taskService.getAllTasks()) {
            addTaskToTable(task);
        }
    }

    private void setupUI() {
        RootPanel.get("app").add(new Label("GWT TODO List"));
        RootPanel.get("app").add(taskTable);

        TextBox taskInput = new TextBox();
        Button addButton = new Button("Add Task");

        addButton.addClickHandler(event -> {
            String description = taskInput.getText().trim();
            
            if (!description.isEmpty()) {
            	
                Task newTask = new Task(description);
                
                taskService.addTask(newTask);
                
                addTaskToTable(newTask);
                
                taskInput.setText("");
                
            }
        });

        RootPanel.get("app").add(taskInput);
        RootPanel.get("app").add(addButton);
    }

    private void addTaskToTable(Task task) {
        int row = taskTable.getRowCount();
        taskTable.setText(row, 0, task.getDescription());
        
        //Status 
        CheckBox statusCheckBox = new CheckBox();
        statusCheckBox.setValue(task.isCompleted());
        statusCheckBox.addClickHandler( event -> {
        	task.setCompleted(statusCheckBox.getValue());
        	taskService.updateTask(task);
        });
        
        taskTable.setWidget(row, 1, statusCheckBox);
        
        //Edit Button
        Button editButton = new Button("Edit");
        taskTable.setWidget(row, 2, editButton);
        editButton.addClickHandler(event -> editTask(task, row));
        
        //Delete Button
        Button deleteButton = new Button("Delete");
        deleteButton.addClickHandler(event -> {
        	taskTable.removeRow(row);
        	taskService.deleteTask(task.getId());
        });
        
        taskTable.setWidget(row, 3, deleteButton);
        
    }
    
    //Edit the task
    public void editTask(Task task, int row) {
    	String newDescription = Window.prompt("Edit Task", task.getDescription());
    	
    	if(newDescription != null) {
    		task.setDescription(newDescription);
    		taskTable.setText(row, 0, newDescription);
    	}
    }

}









