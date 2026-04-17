package org.chain.wallet;

import java.security.PublicKey;
import java.security.MessageDigest;
import java.util.Base64;

public class AddressGenerator {

    public static String generateAddress(PublicKey publicKey) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(publicKey.getEncoded());
            byte[] shortHash = new byte[20];
            System.arraycopy(hash, 0, shortHash, 0, 20);
            return Base64.getEncoder().encodeToString(shortHash);
        } catch (Exception e) {
            throw new RuntimeException("Address generation failed");
        }
    }
}
