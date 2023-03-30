/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Blockchain;

import Class.Completion;
import Class.User;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author putubgs
 */
public class BlockLogic {

    public static String masterFolder = "src/main/java/master";
    public static String userBlock = masterFolder+"/user_information.bin";
    public static String digiCertBlock = masterFolder+"/digital_certificate.bin";
    public static String certBlock = masterFolder+"/course_certificate.bin";
    public static String courseBlock = masterFolder+"/course_completion.bin";
    
    public void userBlock(User user){
        
        Blockchain bc = new Blockchain(userBlock);
        Transaction previousTranxLst = bc.get().getLast().tranxLst;
        Transaction newTranxLst = new Transaction(10);
        if (previousTranxLst != null) {
            for (String t : previousTranxLst.getDataLst()) {
                newTranxLst.add(t);
            }
        }
        String serializedUser = user.toString();
        newTranxLst.add(serializedUser);
        String previousHash = bc.get().getLast().getBlockHeader().getCurrentHash();
        Block b1 = new Block(bc.get().size(), previousHash);
        b1.setTranxLst(newTranxLst);
        bc.nextBlock(b1);
        bc.distribute();
    }
    
    public void courseBlock(Completion c){
        Blockchain bc = new Blockchain(courseBlock);
        Transaction previousTranxLst = bc.get().getLast().tranxLst;
        Transaction newTranxLst = new Transaction(10);
        if (previousTranxLst != null) {
            for (String t : previousTranxLst.getDataLst()) {
                newTranxLst.add(t);
            }
        }
        String serializedUser = c.toString();
        newTranxLst.add(serializedUser);
        String previousHash = bc.get().getLast().getBlockHeader().getCurrentHash();
        Block b1 = new Block(bc.get().size(), previousHash);
        b1.setTranxLst(newTranxLst);
        bc.nextBlock(b1);
        bc.distribute();
    }
    
    public User loginUser(String username, String password, Blockchain bc) {
        LinkedList<Block> chain = bc.get();

        // Get the last block in the chain
        Block lastBlock = chain.getLast();

        Transaction transactionList = lastBlock.tranxLst;
        if (transactionList != null) {
            for (String data : transactionList.getDataLst()) {
                String[] parts = data.split("\\|");
                System.out.println(parts[1]);
                if (parts.length >= 5) {
                    if (parts[1].equals(username) && parts[3].equals(password)) {
                        User user = new User(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
                        return user;
                    }
                }
            }
        }

        return null;
    }

    
    public void updateData(String id, String newData) {
        Blockchain bc = new Blockchain(userBlock);
        Block lastBlock = bc.get().getLast();
        Transaction tranxLst = lastBlock.getTranxLst();

        int index = -1;
        for (int i = 0; i < tranxLst.getDataLst().size(); i++) {
            String[] parts = tranxLst.getDataLst().get(i).split("\\|");
            if (parts[0].equals(id)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            String oldData = tranxLst.getDataLst().get(index);
            String updatedData = id + "|" + newData;
            tranxLst.getDataLst().set(index, updatedData);

            // Create a new block with the updated transaction list
            Block newBlock = new Block(lastBlock.getBlockHeader().getIndex() + 1, lastBlock.getBlockHeader().getCurrentHash());
            newBlock.setTranxLst(tranxLst);

            // Add the new block to the blockchain
            bc.nextBlock(newBlock);
        }
        bc.distribute();
    }


    
    public void certBlock(){
        Blockchain bc = new Blockchain(certBlock);
        Transaction previousTranxLst = bc.get().getLast().tranxLst;
        Transaction newTranxLst = new Transaction(10);
        if (previousTranxLst != null) {
            for (String t : previousTranxLst.getDataLst()) {
                newTranxLst.add(t);
            }
        }
        String serializedUser = "ya";
        System.out.println(serializedUser);
        newTranxLst.add(serializedUser);
        System.out.println(newTranxLst + "hehe");
        String previousHash = bc.get().getLast().getBlockHeader().getCurrentHash();
        Block b1 = new Block(bc.get().size(), previousHash);
        b1.setTranxLst(newTranxLst);
        bc.nextBlock(b1);
        bc.distribute();
    }
    
    public boolean isUserDuplicate(User newUser, Blockchain bc) {
        LinkedList<Block> chain = bc.get();

        for (Block block : chain) {
            Transaction transactionList = block.tranxLst;
            if (transactionList != null) {
                for (String data : transactionList.getDataLst()) {
                    String[] parts = data.split("\\|");
                    if (parts.length >= 5) {
                        if (parts[1].equals(newUser.getUsername()) || parts[2].equals(newUser.getFullName())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}