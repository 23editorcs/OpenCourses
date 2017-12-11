package observer;

import model.random.BingoNumber;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    protected List<GameObserver> observers = new ArrayList<>();

    public void addObservers(GameObserver gameObserver) {
        if (!observers.contains(gameObserver)) {
            observers.add(gameObserver);
        }
    }

    public void notifyObserver(BingoNumber bingoNumber) {
        for (GameObserver observer : observers) {
            observer.update(bingoNumber);
        }
    }
}
