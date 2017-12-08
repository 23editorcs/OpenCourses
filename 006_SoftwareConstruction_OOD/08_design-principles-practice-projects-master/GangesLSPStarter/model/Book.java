package model;

public abstract class Book {
    private String title;
    private double price;
    private Box box;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
        this.box = null; // book starts off unpackaged
    }

    // REQUIRES: model.Box must be medium or large
    // MODIFIES: this
    // EFFECTS:  If the book fits in the given box, then the two are associated (the book is packaged).
    public Box packageBook(Box b) {
        if (b.getSize().equals(this.getMinBoxSize())){
            System.out.println("The book fits snugly into this box.");
            this.setBox(b);
            b.setContents(this);
            return b;
        } else {
            System.out.println("This box is not fit with the book. Please pick another one.");
            return null;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    // EFFECTS: Returns the flat rate for shipping a standard sized book
    public abstract double calculateShipping();

    // EFFECTS: returns the minimum required size of box for packaging this book
    public abstract String getMinBoxSize();
}
