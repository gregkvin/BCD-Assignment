package Blockchain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author putubgs
 */
public class Transaction implements Serializable{
    private final int SIZE = 10;
    
    /* we will come back for creating merkle root in another session */
    private String merkleRoot = "0";
    
    private List<String> dataLst = new ArrayList<>();
    
    public void add(String tranx) {
        if (dataLst.size() < SIZE) {
            dataLst.add(tranx);
            calculateMerkleRoot();
        }
    }

    public void calculateMerkleRoot() {
        MerkleTree merkleTree = MerkleTree.getInstance(dataLst);
        merkleTree.build();
        this.merkleRoot = merkleTree.getRoot();
    }
    
    @Override
    public String toString() {
        return "Transaction [SIZE=" + SIZE + ", merkleRoot=" + merkleRoot + ", dataLst=" + dataLst + "]";
    }
    
}
