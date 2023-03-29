/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Blockchain;

import Class.User;
import java.io.File;
import java.util.LinkedList;

/**
 *
 * @author putubgs
 */
public class BlockLogic {

    public static String masterFolder = "src/main/java/master";
    public static String userBlock = masterFolder+"/user_information.bin";
    public static String certBlock = masterFolder+"/digital_certificate.bin";
    
    public void userBlock(User user){
        Blockchain bc = Blockchain.getInstance( userBlock );
        Transaction previousTranxLst = bc.get().getLast().tranxLst;
        Transaction newTranxLst = new Transaction(10);
        if (previousTranxLst != null) {
            for (String t : previousTranxLst.getDataLst()) {
                newTranxLst.add(t);
            }
        }
        String serializedUser = user.toString();
        System.out.println(serializedUser);
        newTranxLst.add(serializedUser);
        System.out.println(newTranxLst + "hehe");
        String previousHash = bc.get().getLast().getBlockHeader().getCurrentHash();
        Block b1 = new Block(bc.get().size(), previousHash);
        b1.setTranxLst(newTranxLst);
        bc.nextBlock(b1);
        bc.distribute();
    }
    
    public User findUser(String username, String password, Blockchain bc) {
        LinkedList<Block> chain = bc.get();
    
        for (Block block : chain) {
            Transaction transactionList = block.tranxLst;
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
        }
    
        return null;
    }
    
    public void certBlock(){
        Blockchain bc = Blockchain.getInstance( certBlock );
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