package org.chain.contract;

import java.util.HashMap;
import java.util.Map;

public class TokenContractLogic {
    private final String tokenName;
    private final String symbol;
    private final int totalSupply;
    private final Map<String, Integer> balances;

    public TokenContractLogic(String name, String symbol, int supply) {
        this.tokenName = name;
        this.symbol = symbol;
        this.totalSupply = supply;
        this.balances = new HashMap<>();
        balances.put("owner", supply);
    }

    public boolean transfer(String from, String to, int amount) {
        if (balances.getOrDefault(from, 0) < amount || amount <= 0) return false;
        balances.put(from, balances.get(from) - amount);
        balances.put(to, balances.getOrDefault(to, 0) + amount);
        return true;
    }

    public int balanceOf(String address) {
        return balances.getOrDefault(address, 0);
    }

    public String getTokenName() { return tokenName; }
    public String getSymbol() { return symbol; }
    public int getTotalSupply() { return totalSupply; }
}
