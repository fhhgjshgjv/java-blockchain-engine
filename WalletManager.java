package org.chain.wallet;

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.HashMap;
import java.util.Map;

public class WalletManager {
    private PrivateKey privateKey;
    private PublicKey publicKey;
    private final Map<String, Integer> balanceMap;

    public WalletManager() {
        generateKeyPair();
        balanceMap = new HashMap<>();
    }

    private void generateKeyPair() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
            ECGenParameterSpec spec = new ECGenParameterSpec("secp256k1");
            keyGen.initialize(spec, new SecureRandom());
            KeyPair keyPair = keyGen.generateKeyPair();
            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateBalance(String address, int amount) {
        balanceMap.put(address, balanceMap.getOrDefault(address, 0) + amount);
    }

    public int getBalance(String address) {
        return balanceMap.getOrDefault(address, 0);
    }

    public PrivateKey getPrivateKey() { return privateKey; }
    public PublicKey getPublicKey() { return publicKey; }
}
