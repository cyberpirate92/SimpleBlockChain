package com.zen;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class BlockChain {
    public List<Block> chain;
    private int difficulty;

    public BlockChain(int difficulty) {
        chain = new ArrayList<>();
        this.difficulty = difficulty;
    }

    public void addBlock(Block block) throws NoSuchAlgorithmException {

        block.previousBlockHash = chain.size() == 0
                ? CryptoHelper.sha256("0")
                : chain.get(chain.size()-1).getHash();

        block.mine(difficulty);
        chain.add(block);
    }

    public boolean isValid() throws NoSuchAlgorithmException {
        var pre = "";
        for(;pre.length() < difficulty; pre += "0");
        for (var i=1; i<chain.size(); ++i) {
            var previousBlock = chain.get(i-1);
            var currentBlock = chain.get(i);
            if (!currentBlock.getHash().startsWith(pre) || !currentBlock.previousBlockHash.equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }
}
