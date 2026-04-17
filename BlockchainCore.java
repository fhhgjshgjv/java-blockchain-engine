package org.chain.core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class BlockchainCore {
    private final List<Block> chain;
    private static final int DIFFICULTY = 4;

    public BlockchainCore() {
        this.chain = new ArrayList<>();
        createGenesisBlock();
    }

    private void createGenesisBlock() {
        Block genesis = new Block(0, "0", "Genesis Block", System.currentTimeMillis());
        genesis.mineBlock(DIFFICULTY);
        chain.add(genesis);
    }

    public void addBlock(String data) {
        Block lastBlock = getLastBlock();
        Block newBlock = new Block(
                lastBlock.getIndex() + 1,
                lastBlock.getHash(),
                data,
                System.currentTimeMillis()
        );
        newBlock.mineBlock(DIFFICULTY);
        chain.add(newBlock);
    }

    public Block getLastBlock() {
        return chain.get(chain.size() - 1);
    }

    public boolean validateChain() {
        for (int i = 1; i < chain.size(); i++) {
            Block current = chain.get(i);
            Block previous = chain.get(i - 1);
            if (!current.getHash().equals(calculateHash(current)) || !current.getPreviousHash().equals(previous.getHash())) {
                return false;
            }
        }
        return true;
    }

    public static String calculateHash(Block block) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String input = block.getIndex() + block.getPreviousHash() + block.getTimestamp() + block.getData() + block.getNonce();
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Block> getChain() {
        return chain;
    }
}
