package model;

public abstract class Doable {

    protected String description;
    protected boolean complete;

    public Doable(String description) {
        this.description = description;
        this.complete = false;
    }

    // getters
    public String getDescription() {
        return description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void complete() {
        if (!this.complete) {
            this.complete = true;
        }
    }

    public void display(String indentSpace) {
        System.out.println(indentSpace + getDescription());
    }
}
