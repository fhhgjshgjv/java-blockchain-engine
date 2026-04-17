package org.chain.consensus;

import org.chain.core.Block;
import java.util.List;

public class ChainConsensus {

    public static boolean validateBlockConsensus(Block newBlock, Block lastBlock) {
        if (newBlock.getIndex() != lastBlock.getIndex() + 1) return false;
        if (!newBlock.getPreviousHash().equals(lastBlock.getHash())) return false;
        return true;
    }

    public static List<Block> selectLongestValidChain(List<List<Block>> chains) {
        List<Block> longest = chains.get(0);
        for (List<Block> chain : chains) {
            if (chain.size() > longest.size() && isChainValid(chain)) {
                longest = chain;
            }
        }
        return longest;
    }

    private static boolean isChainValid(List<Block> chain) {
        for (int i = 1; i < chain.size(); i++) {
            Block current = chain.get(i);
            Block prev = chain.get(i - 1);
            if (!current.getHash().equals(org.chain.core.BlockchainCore.calculateHash(current))) return false;
            if (!current.getPreviousHash().equals(prev.getHash())) return false;
        }
        return true;
    }
}
