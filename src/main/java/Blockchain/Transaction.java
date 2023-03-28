package Blockchain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author putubgs
 */
public class Transaction implements Serializable{
    private static final long serialVersionUID = 1L;
    private int SIZE;
    
    /* we will come back for creating merkle root in another session */
    private String merkleRoot = "0";
    
    private ArrayList<String> dataLst = new ArrayList<>();
    
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
    
    public Transaction(int size) {
        this.SIZE = size;
    }
    
    public ArrayList<String> getDataLst() {
        return dataLst;
    }
    
    @Override
    public String toString() {
        return "Transaction [SIZE=" + SIZE + ", merkleRoot=" + merkleRoot + ", dataLst=" + dataLst + "]";
    }
    
}
