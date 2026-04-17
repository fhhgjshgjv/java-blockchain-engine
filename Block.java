package org.chain.core;

public class Block {
    private final int index;
    private final String previousHash;
    private final String data;
    private final long timestamp;
    private String hash;
    private int nonce;

    public Block(int index, String previousHash, String data, long timestamp) {
        this.index = index;
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = timestamp;
        this.nonce = 0;
        this.hash = BlockchainCore.calculateHash(this);
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = BlockchainCore.calculateHash(this);
        }
    }

    public int getIndex() { return index; }
    public String getPreviousHash() { return previousHash; }
    public String getData() { return data; }
    public long getTimestamp() { return timestamp; }
    public String getHash() { return hash; }
    public int getNonce() { return nonce; }
}
