package org.chain.api;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import org.chain.core.BlockchainCore;
import java.io.IOException;
import java.io.OutputStream;

public class ChainHandler implements HttpHandler {
    private final BlockchainCore core;

    public ChainHandler(BlockchainCore core) {
        this.core = core;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "{\"height\":" + core.getChain().size() + ",\"valid\":" + core.validateChain() + "}";
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.length());
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
