package org.chain.api;

import com.sun.net.httpserver.HttpServer;
import org.chain.core.BlockchainCore;
import java.net.InetSocketAddress;

public class ChainAPIServer {
    private final BlockchainCore core;
    private HttpServer server;

    public ChainAPIServer(BlockchainCore core) {
        this.core = core;
    }

    public void start(int port) {
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
            server.createContext("/chain", new ChainHandler(core));
            server.createContext("/mine", new MineHandler(core));
            server.setExecutor(null);
            server.start();
            System.out.println("API Server running on port " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (server != null) server.stop(0);
    }
}
