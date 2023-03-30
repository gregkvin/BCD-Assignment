/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blockchain;

import java.io.Serializable;
import Hashing.Hasher;

/**
 *
 * @author putubgs
 */
public class Block implements Serializable{
    public Header blockHeader;
    public Header getBlockHeader() {
        return blockHeader;
    }
    /* composition relationship */
    public Block(int index, String previousHash) {
        super();
        long now = System.currentTimeMillis();
        /* construct part object upon object construction */
        this.blockHeader = new Header();
        this.blockHeader.setPreviousHash(previousHash);
        this.blockHeader.setTimestamp(now);
        //hashing with sha256 - the input is joined with previousHash+now
        String currentHash = Hasher.sha256( 
                String.join("+", previousHash, String.valueOf(now)) );
        this.blockHeader.setCurrentHash(currentHash);
        System.out.println(Hasher.sha256(String.valueOf(now)));
    }
    /* composition relationship - inner class definition for part object*/
    public class Header implements Serializable{
        //data member
        private static final long serialVersionUID = 1L;
        private int index;
        private String currentHash, previousHash;
        private long timestamp;
        
        @Override
        public String toString() {
            return "Header [index=" + index + ", currentHash=" + currentHash + ", previousHash=" + previousHash
                    + ", timestamp=" + timestamp + "]";
        }
        
        //getset methods
        public String getCurrentHash() {
            return currentHash;
        }
        public void setCurrentHash(String currentHash) {
            this.currentHash = currentHash;
        }
        public String getPreviousHash() {
            return previousHash;
        }
        public void setPreviousHash(String previousHash) {
            this.previousHash = previousHash;
        }
        public long getTimestamp() {
            return timestamp;
        }
        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }
        public void setIndex(int index) {
            this.index = index;
        }
        public int getIndex() {
            return index;
        }

        
    }
    
    /* aggregation relationship */
    public Transaction tranxLst;
    public void setTranxLst(Transaction tranxLst) {
        this.tranxLst = tranxLst;
        if (tranxLst != null) {
            tranxLst.calculateMerkleRoot();
        }
    }
    
    public Transaction getTranxLst() {
        return tranxLst;
    }
    @Override
    public String toString() {
        if (tranxLst != null) {
            tranxLst.calculateMerkleRoot();
        }
        return "Block [blockHeader=" + blockHeader + ", tranxLst=" + tranxLst + "]";
    }
    
    
}