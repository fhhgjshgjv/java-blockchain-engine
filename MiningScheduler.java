package org.chain.mining;

import org.chain.core.BlockchainCore;
import org.chain.transaction.TransactionPool;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MiningScheduler {
    private final BlockchainCore core;
    private final TransactionPool pool;
    private final ScheduledExecutorService executor;

    public MiningScheduler(BlockchainCore core, TransactionPool pool) {
        this.core = core;
        this.pool = pool;
        this.executor = Executors.newScheduledThreadPool(1);
    }

    public void startAutoMining() {
        executor.scheduleWithFixedDelay(() -> {
            if (pool.getPoolSize() > 0) {
                core.addBlock("Processed " + pool.getPoolSize() + " transactions");
                pool.removeProcessedTransactions(pool.getPendingTransactions(10));
            }
        }, 3, 3, TimeUnit.SECONDS);
    }

    public void stopMining() {
        executor.shutdown();
    }
}
