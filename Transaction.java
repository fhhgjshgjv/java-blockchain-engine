package org.chain.transaction;

import java.security.PublicKey;

public class Transaction {
    private final PublicKey sender;
    private final PublicKey recipient;
    private final int amount;
    private final byte[] signature;
    private final String txId;

    public Transaction(PublicKey sender, PublicKey recipient, int amount, byte[] signature) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.signature = signature;
        this.txId = generateTxId();
    }

    private String generateTxId() {
        return Integer.toHexString(hashCode());
    }

    public boolean validateTransaction() {
        return amount > 0 && signature != null && sender != null && recipient != null;
    }

    public PublicKey getSender() { return sender; }
    public PublicKey getRecipient() { return recipient; }
    public int getAmount() { return amount; }
    public byte[] getSignature() { return signature; }
    public String getTxId() { return txId; }
}
