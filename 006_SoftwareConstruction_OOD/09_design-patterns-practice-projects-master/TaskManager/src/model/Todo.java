package model;

import java.util.LinkedList;
import java.util.List;


public class Todo extends Doable{

      private List<Doable> subs;

    public Todo(String description) {
        super(description);
        subs = new LinkedList<>();
    }

    // getters
      public List<Doable> getSubTasks() { return subs; }

      public boolean addDoable(Doable d) {
          if (!subs.contains(d)){
              subs.add(d);
              return true;
          }
          return false;
      }

      public boolean removeDoable(Doable d) {
          if (subs.contains(d)) {
              subs.remove(d);
              return true;
          }
          return false;
      }

    public boolean isTodoComplete() {
        boolean areTodoComplete = true;
        for (Doable d : subs) {
            if (!d.isComplete()) {
                areTodoComplete = false;
                break;
            }
        }
        this.complete = areTodoComplete;
        return complete;
    }

    public void display(String indentSpace) {
        System.out.println(indentSpace + getDescription());
        for (Doable d : subs) {
            d.display(indentSpace + indentSpace);
        }
    }
}