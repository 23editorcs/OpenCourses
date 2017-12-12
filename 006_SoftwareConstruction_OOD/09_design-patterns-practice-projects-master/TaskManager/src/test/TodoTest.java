package test;

import model.Doable;
import model.Task;
import model.Todo;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TodoTest {

    private Todo todo;

    private Todo t1;
    private Todo t2;
    private Todo t3;
    private Task ta1;
    private Task ta2;
    private Task ta3;

    @Before
    public void setUp() {
        todo = new Todo("Tech me CS!");

        t1 = new Todo("Programming");
        t2 = new Todo("Algorithms");
        t3 = new Todo("Database");

        ta1 = new Task("Design Pattern", "Today", "Library");
        ta2 = new Task("Create a plan", "Today", "Home");
        ta3 = new Task("Go to party", "Tomorrow", "Company");

        todo.addDoable(t1);
        todo.addDoable(t2);
        todo.addDoable(t3);
        todo.addDoable(ta2);
        todo.addDoable(ta3);

        t1.addDoable(ta1);
    }

    @Test
    public void testGetters(){
        assertEquals(todo.getDescription(),"Tech me CS!");
        assertFalse(todo.isComplete());
        todo.complete();
        assertTrue(todo.isComplete());
    }

    @Test
    public void testAddDoable() {
        assertEquals(todo.getSubTasks().size(), 5);
    }

    @Test
    public void testRemoveDoable() {
        todo.removeDoable(t3);
        assertEquals(4, todo.getSubTasks().size());
        todo.removeDoable(ta2);
        assertEquals(3, todo.getSubTasks().size());
        todo.removeDoable(ta1); // can't remove a task in sub todo
        assertEquals(3, todo.getSubTasks().size());
    }

    @Test
    public void testAreTodoComplete() {
        assertFalse(todo.isTodoComplete());
        t1.complete();
        t2.complete();
        t3.complete();
        ta1.complete();
        ta2.complete();
        ta3.complete();
        assertTrue(todo.isTodoComplete());
    }
}
