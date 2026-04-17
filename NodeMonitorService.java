package org.chain.monitor;

import org.chain.core.BlockchainCore;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NodeMonitorService {
    private final BlockchainCore core;
    private final ScheduledExecutorService scheduler;

    public NodeMonitorService(BlockchainCore core) {
        this.core = core;
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public void startMonitor() {
        scheduler.scheduleAtFixedRate(this::logNodeStatus, 0, 5, TimeUnit.SECONDS);
    }

    private void logNodeStatus() {
        System.out.println("=== Node Status ===");
        System.out.println("Chain Height: " + core.getChain().size());
        System.out.println("Chain Valid: " + core.validateChain());
        System.out.println("===================");
    }

    public void stopMonitor() {
        scheduler.shutdown();
    }
}
