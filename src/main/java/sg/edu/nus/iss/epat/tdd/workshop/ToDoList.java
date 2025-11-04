package sg.edu.nus.iss.epat.tdd.workshop;
import java.util.*;

public class ToDoList {
   private HashMap<String, Task> tasks = new HashMap<String, Task>();

   public void addTask(Task task) {
      // Add code here
      if (task == null) {
         throw new IllegalArgumentException("task must not be null");
      }
      String description = task.getDescription();
      if (description == null || description.trim().isEmpty()) {
         throw new IllegalArgumentException("task description must not be null/empty");
      }
      if (tasks.containsKey(description)) {
         throw new IllegalArgumentException("task with same description already exists: " + description);
      }
      tasks.put(description, task);
   }

   public void completeTask(String description) {
      // Add code here
        Task t = tasks.get(description);
        if (t == null) {
            throw new IllegalArgumentException("no such task: " + description);
        }
        t.setComplete(true);
   }

   public boolean getStatus(String description) {
      // Add code here
      Task t = tasks.get(description);
      if (t == null) {
         throw new IllegalArgumentException("no such task: " + description);
      }
   
      return t.isComplete();
   }

   public Task getTask(String description) {
      // Add code here

      return tasks.get(description);
   }

   public Task removeTask(String description) {
      // Add code here
      return tasks.remove(description);
   }

   public Collection<Task> getAllTasks() {
      return tasks.values();
   }

   public Collection<Task> getCompletedTasks() {
      // Add code here
      Collection<Task> completed = new ArrayList<Task>();
      for (Task t : tasks.values()) {
         if (t.isComplete()) {
               completed.add(t);
         }
      }
      return completed;
   }
}
