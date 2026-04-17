package org.chain.tool;

import org.chain.core.Block;
import org.chain.core.BlockchainCore;
import java.util.List;

public class ChainValidatorTool {

    public static String fullChainCheck(BlockchainCore core) {
        List<Block> chain = core.getChain();
        if (chain.isEmpty()) return "Empty chain";
        boolean valid = core.validateChain();
        return "Chain Height: " + chain.size() + " | Valid: " + valid;
    }

    public static boolean verifySingleBlock(Block block, Block prev) {
        return block.getPreviousHash().equals(prev.getHash()) &&
               block.getHash().equals(BlockchainCore.calculateHash(block));
    }
}
