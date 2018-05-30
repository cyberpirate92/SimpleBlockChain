package com.zen;

public class Main {
    public static void main(String[] args) {
        try {
            var difficulty = 5;
            var blockChain = new BlockChain(difficulty);

            Block block1 = new Block("Hello");
            Block block2 = new Block("World");
            Block block3 = new Block("Whatever");

            blockChain.addBlock(block1);
            blockChain.addBlock(block2);
            blockChain.addBlock(block3);

            System.out.println(String.format("%64s\t%13s\t%7s\t%s", "Previous hash", "Timestamp", "Nonce", "Transaction Data"));
            for (Block block: blockChain.chain) {
                System.out.println(block);
            }

            System.out.println("Is valid chain : " + blockChain.isValid());

            blockChain.chain.get(1).transactionData = "World1";
            System.out.println("Is valid chain : " + blockChain.isValid());

        }
        catch(Exception e) {
            System.err.println(e);
        }
    }
}
