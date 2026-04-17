package org.chain.api;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import org.chain.core.BlockchainCore;
import java.io.IOException;
import java.io.OutputStream;

public class MineHandler implements HttpHandler {
    private final BlockchainCore core;

    public MineHandler(BlockchainCore core) {
        this.core = core;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        core.addBlock("Mined via API");
        String response = "{\"status\":\"success\",\"message\":\"new block created\"}";
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.length());
        try (OutputStream os = exchangeResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
