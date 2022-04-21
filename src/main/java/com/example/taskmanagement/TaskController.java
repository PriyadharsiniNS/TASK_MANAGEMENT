package com.example.taskmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

	@Autowired
	public TaskService ts;
	
	@PostMapping("/saveTask")
	public void addTask(@RequestBody Task v)
	{
		ts.addTask(v);
	}
	
	@GetMapping("/changeStatus/{taskId}")
	public void changeStatus(@PathVariable String taskId,@RequestBody Task v)
	{
		ts.changeTaskStatus(taskId,v);
	}
	
	@DeleteMapping("/deleteHouse/{taskId}")
	public void deleteTask(@PathVariable String taskId)
	{
		ts.deleteTaskById(taskId);
	}
	
	@GetMapping("/alltasks")
	public List<Task> getAllTasks(@RequestBody Task v)
	{
		return ts.getAllTasks(v);
	}
	
	@GetMapping("/getTask/{taskHolderName}")
	public List<Task> getTask(@PathVariable String taskHolderName, @RequestBody Task v)
	{
		return ts.getTaskByHolderName(taskHolderName,v);
	}
}
