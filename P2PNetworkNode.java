package org.chain.network;

import java.net.*;
import java.io.*;
import java.util.*;

public class P2PNetworkNode {
    private final int port;
    private final Set<Socket> connectedNodes;
    private ServerSocket serverSocket;

    public P2PNetworkNode(int port) {
        this.port = port;
        this.connectedNodes = new HashSet<>();
    }

    public void startServer() {
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(port);
                while (!serverSocket.isClosed()) {
                    Socket socket = serverSocket.accept();
                    connectedNodes.add(socket);
                    handleNodeCommunication(socket);
                }
            } catch (IOException e) {
                System.out.println("P2P node server stopped");
            }
        }).start();
    }

    private void handleNodeCommunication(Socket socket) {
        new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String msg;
                while ((msg = reader.readLine()) != null) {
                    broadcastMessage(msg);
                }
            } catch (IOException e) {
                connectedNodes.remove(socket);
            }
        }).start();
    }

    public void connectToNode(String host, int port) {
        try {
            Socket socket = new Socket(host, port);
            connectedNodes.add(socket);
            handleNodeCommunication(socket);
        } catch (IOException e) {
            System.out.println("Failed to connect to peer node");
        }
    }

    public void broadcastMessage(String message) {
        for (Socket socket : connectedNodes) {
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopNode() {
        try {
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
