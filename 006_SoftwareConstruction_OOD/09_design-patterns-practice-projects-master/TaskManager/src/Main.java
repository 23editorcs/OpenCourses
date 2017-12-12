import model.Task;
import model.Todo;

public class Main {
    public static Todo todo;

    private static Todo t1;
    private static Todo t2;
    private static Todo t3;
    private static Task ta1;
    private static Task ta2;
    private static Task ta3;

    public static void main(String[] args) {
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

        todo.display("  ");

    }
}
