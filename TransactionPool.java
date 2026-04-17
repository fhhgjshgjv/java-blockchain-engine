package org.chain.transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TransactionPool {
    private final List<Transaction> pendingTransactions;

    public TransactionPool() {
        pendingTransactions = new CopyOnWriteArrayList<>();
    }

    public void addTransaction(Transaction tx) {
        if (tx.validateTransaction()) {
            pendingTransactions.add(tx);
        }
    }

    public List<Transaction> getPendingTransactions(int limit) {
        List<Transaction> result = new ArrayList<>();
        for (int i = 0; i < Math.min(limit, pendingTransactions.size()); i++) {
            result.add(pendingTransactions.get(i));
        }
        return result;
    }

    public void removeProcessedTransactions(List<Transaction> processed) {
        pendingTransactions.removeAll(processed);
    }

    public int getPoolSize() {
        return pendingTransactions.size();
    }
}
