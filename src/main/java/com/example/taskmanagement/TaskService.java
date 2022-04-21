package com.example.taskmanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskService {
	
	@Autowired
	public TaskRepository tr;

	public void changeTaskStatus(String taskId, Task v) {
		tr.save(v);
	}

	public void deleteTaskById(String taskId) {
		tr.deleteById(taskId);
	}

	public List<Task> getAllTasks(Task v) {
		List<Task> k = new ArrayList<Task>();
		tr.findAll().forEach(k::add);
		return k;
	}

	public List<Task> getTaskByHolderName(String taskHolderName, Task v) {
		List<Task> m = new ArrayList<Task>();
		v.setTaskHolderName(taskHolderName);
		if(v.getTaskHolderName().toString()==taskHolderName)
			m.add(v);
		return m;
	}

	public void addTask(Task v) {
		tr.save(v);
	}

}
