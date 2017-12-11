package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Inventory implements Iterable<Toy> {
    private Collection<Toy> toys = new ArrayList<>();
    private Collection<Toy> backlog = new ArrayList<>();
    private ArrayList<String> log = new ArrayList<>();

    // getters
    public int getSize() { return toys.size(); }

    public void add(Toy t) {
        toys.add(t);
        log.add("New toy added: "+t);
    }

    public void remove(Toy t){
        toys.remove(t);
        log.add("Toy "+t+" removed");
    }


    public void printQueryStats(){
        for(String logEntry : log){
            System.out.println(logEntry);
        }
    }

    public void moveToBacklog(Toy toy) {
        toys.remove(toy);
        backlog.add(toy);
    }


    @Override
    public Iterator<Toy> iterator() {
        return new ToyIterator();
    }

    private class ToyIterator implements Iterator<Toy> {

        private Iterator toyIterator = toys.iterator();
        private Iterator logIterator = backlog.iterator();

        @Override
        public boolean hasNext() {
            System.out.println("Must has next!");
            return toyIterator.hasNext() || logIterator.hasNext();
        }

        @Override
        public Toy next() {
            if (toyIterator.hasNext()) {
                System.out.println("Toy!!");
                return (Toy) toyIterator.next();
            }
            else {
                System.out.println("Log!!");
                return (Toy) logIterator.next();
            }
        }
    }
}