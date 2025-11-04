package sg.edu.nus.iss.epat.tdd.workshop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;

public class ToDoListTest  {
    // Define Test Fixtures
    private ToDoList toDoList;


    public ToDoListTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        // Initialise Test Fixtures
        toDoList = new ToDoList();
    }

    @After
    public void tearDown() throws Exception {
        // Uninitialise test Fixtures
        toDoList = null;
    }

    @Test
    public void testAddTask() {
        // fail("Not implemented yet");
        Task task = new Task("Go gym");
        toDoList.addTask(task);
        assertTrue("All tasks should contain the added task", toDoList.getAllTasks().contains(task));

    }

    @Test
    public void testGetStatus() {
        // fail("Not implemented yet");
        toDoList.addTask(new Task("Go gym"));
        assertFalse("New tasks should default to incomplete", toDoList.getStatus("Go gym"));
    }

    @Test
    public void testRemoveTask() {
        // fail("Not implemented yet");
        toDoList.addTask(new Task("Go eat"));
        toDoList.addTask(new Task("Go sleep"));
        toDoList.addTask(new Task("Go shower"));

        Task t = new Task("Go gym");
        toDoList.addTask(t);

        Task removed = toDoList.removeTask("Go gym");
        assertNotNull("Removing an existing task should return it", removed);
        assertEquals("Removed task should be the same instance", t, removed);
        assertNull("Task should no longer be retrievable", toDoList.getTask("Go gym"));
    }

    @Test
    public void testGetCompletedTasks() {
        // fail("Not implemented yet");
        Task a = new Task("Go gym");
        Task b = new Task("Go eat", true);
        Task c = new Task("Go sleep");
        toDoList.addTask(a);
        toDoList.addTask(b);
        toDoList.addTask(c);

        toDoList.completeTask("Go sleep");
        Collection<Task> done = toDoList.getCompletedTasks();

        assertEquals("Two tasks should be complete", 2, done.size());
        assertTrue(done.contains(b));
        assertTrue(done.contains(c));
        assertFalse(done.contains(a));
    }
}