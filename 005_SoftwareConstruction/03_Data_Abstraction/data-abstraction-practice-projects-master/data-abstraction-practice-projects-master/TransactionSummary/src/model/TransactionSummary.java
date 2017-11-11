package model;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;


public class TransactionSummary {

    private String name;
    private List<Transaction> transactions;

    public TransactionSummary(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    // getters
    public String getName() {
        return name;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public int getNumTransactions() {
        return transactions.size();
    }

    // REQUIRES: t is not already within transactions
    // MODIFIES: this
    // EFFECTS: adds the given transaction t to the list of transactions
    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS: computes the average amount of money spent on a transaction
    public double averageTransactionCost() {
        double totalCost = 0.0;
        for (int i=0; i<transactions.size(); i++){
            totalCost += transactions.get(i).getAmount();
        }
        double sizeA = transactions.size();
        double result = totalCost / sizeA;
        System.out.println(MessageFormat.format("{0} {1} {2}", totalCost, sizeA, result));
        return  result;
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS:  returns the average cost of all transactions of type specificType in this
    //           TransactionSummary
    public double specificTypeAverage(TransactionType specificType) {
        double totalCost = 0.0;
        int counts = 0;
        for (Transaction t: transactions
             ) {
            if (t.getType() == specificType){
                totalCost += t.getAmount();
                counts += 1;
            }
        }
        return totalCost/counts;
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS: returns the largest transaction (in terms of cost) in this TransactionSummary
    public Transaction largestTransaction() {
        // TODO: complete the implementation of this method
        //transactions.sort(Comparator.comparing(Transaction::getAmount).reversed());
        //transactions.sort(((o1, o2) -> o1.getAmount().compareTo(o2.getAmount())));
        Transaction largest = transactions.get(0);

        for(Transaction t: transactions) {
            if (t.getAmount() > largest.getAmount()) {
                largest = t;
            }
        }

        return largest;
    }

    // EFFECTS: returns true if the given transaction is contained within the list of transactions
    public boolean contains(Transaction t) {
        // TODO: complete the implementation of this method
        return transactions.contains(t);
    }


}
