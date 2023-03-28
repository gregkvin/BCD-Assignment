/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Blockchain;

import java.util.ArrayList;
import java.util.List;
import Hashing.Hasher;

public class MerkleTree {
    private List<String> tranxLst;
    private String root = "0";
    public String getRoot() {
        return root;
    }
    private MerkleTree(List<String> tranxLst) {
        super();
        this.tranxLst = tranxLst;
    }
    private static MerkleTree instance;
    public static MerkleTree getInstance(List<String> tranxLst) {
        return new MerkleTree(tranxLst);
    }

    public void build() {
        List<String> tempLst = new ArrayList<>();
        for (String tranx : this.tranxLst) {
            tempLst.add(tranx);
        }
        List<String> hashes = genTranxHashLst( tempLst );
        while(  hashes.size() != 1 ) {
            hashes = genTranxHashLst( hashes );
        }
        this.root = hashes.get(0);
    }
    private List<String> genTranxHashLst(List<String> tranxLst) {
        List<String> hashLst = new ArrayList<>();
        int i = 0;
        while( i < tranxLst.size() ) {
            String left = tranxLst.get(i);
            i++;
            String right = "";
            if( i != tranxLst.size() ) right = tranxLst.get(i);
            String hash = Hasher.sha256(left.concat(right));
            hashLst.add(hash);
            i++;
        }
        return hashLst;
    }
}
