package org.chain.sync;

import org.chain.core.Block;
import org.chain.core.BlockchainCore;
import java.util.List;

public class ChainSyncService {
    private final BlockchainCore localChain;

    public ChainSyncService(BlockchainCore localChain) {
        this.localChain = localChain;
    }

    public void syncWithPeer(List<Block> peerChain) {
        if (peerChain.size() > localChain.getChain().size() && validatePeerChain(peerChain)) {
            replaceLocalChain(peerChain);
        }
    }

    private boolean validatePeerChain(List<Block> chain) {
        for (int i = 1; i < chain.size(); i++) {
            Block curr = chain.get(i);
            Block prev = chain.get(i - 1);
            if (!curr.getPreviousHash().equals(prev.getHash())) return false;
        }
        return true;
    }

    private void replaceLocalChain(List<Block> newChain) {
        localChain.getChain().clear();
        localChain.getChain().addAll(newChain);
    }
}
