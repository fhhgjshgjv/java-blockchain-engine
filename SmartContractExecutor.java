package org.chain.contract;

import java.util.HashMap;
import java.util.Map;

public class SmartContractExecutor {
    private final Map<String, ContractFunction> functionMap;
    private final Map<String, Object> contractState;

    public SmartContractExecutor() {
        functionMap = new HashMap<>();
        contractState = new HashMap<>();
    }

    public void registerFunction(String name, ContractFunction function) {
        functionMap.put(name, function);
    }

    public Object executeContract(String functionName, Map<String, Object> params) {
        if (!functionMap.containsKey(functionName)) {
            throw new IllegalArgumentException("Contract function not found");
        }
        return functionMap.get(functionName).execute(params, contractState);
    }

    public Object getState(String key) {
        return contractState.get(key);
    }

    public void setState(String key, Object value) {
        contractState.put(key, value);
    }
}
