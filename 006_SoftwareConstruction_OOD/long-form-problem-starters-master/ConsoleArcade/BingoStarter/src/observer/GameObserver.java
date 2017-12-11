package observer;

import model.random.BingoNumber;

public interface GameObserver {

    void update(BingoNumber bingoNumber);
}
