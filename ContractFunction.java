package org.chain.contract;

import java.util.Map;

@FunctionalInterface
public interface ContractFunction {
    Object execute(Map<String, Object> params, Map<String, Object> state);
}
