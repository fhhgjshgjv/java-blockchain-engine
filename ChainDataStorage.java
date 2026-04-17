package org.chain.storage;

import org.chain.core.Block;
import java.io.*;
import java.util.List;

public class ChainDataStorage {
    private static final String FILE_PATH = "blockchain.dat";

    public static void saveChain(List<Block> chain) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(chain);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Block> loadChain() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Block>) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}
