package com.training.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class TaskService {
	private List<Task> taskList = new ArrayList<>();
	private int nextId = 1;

	// Add Task
	public void addTask(Task task) {
		task.setId(nextId++);
		taskList.add(task);
	}

	// get all tasks
	public List<Task> getAllTasks() {
		return taskList;
	}
	
	public Task getTaskById(int taskId) {
		for(Task task: taskList) {
			if(task.getId() == taskId) {
				return task;
			}
		}
		return null; //Task not found
	}
	
	public void updateTask(Task updatedTask) {
		for(int i = 0; i < taskList.size(); i++) {
			//existing task info from table
			Task task = taskList.get(i);
			if(task.getId() == updatedTask.getId()) {
				taskList.set(i, updatedTask);
				return;
			}
		}
	}
	
	public void deleteTask(int taskId) {
		Iterator<Task> iterator = taskList.iterator();
		while(iterator.hasNext()){
			Task task = iterator.next();
			if(task.getId() == taskId) {
				iterator.remove();
				return;
			}
		}
	}

}
