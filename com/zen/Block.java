package com.zen;

import java.security.NoSuchAlgorithmException;

public class Block {
    public String transactionData;
    private long timestamp;
    public String previousBlockHash;
    public long nonce;

    public Block(String transactionData) {
        nonce = 0;
        timestamp = System.currentTimeMillis();
        this.transactionData = transactionData;
    }

    public String getHash() throws NoSuchAlgorithmException {
        return CryptoHelper.sha256(transactionData
                + String.valueOf(timestamp)
                + String.valueOf(previousBlockHash)
                + String.valueOf(nonce)
        );
    }

    public void mine(int difficulty) throws NoSuchAlgorithmException {
        String pre = "";
        for (; pre.length()<difficulty; pre += "0");
        while(!getHash().startsWith(pre)) nonce++;
    }

    @Override
    public String toString() {
        return String.format("%s\t%d\t%7d\t%s", previousBlockHash, timestamp, nonce, transactionData);
    }
}