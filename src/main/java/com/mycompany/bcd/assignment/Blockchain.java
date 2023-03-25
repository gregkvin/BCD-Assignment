/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bcd.assignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.in;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gregoriuskevin
 */
public class Blockchain {
    
    private static LinkedList<Block> blockch = new LinkedList<>();
    private String ledgerFile = "login.txt";
    
    public void genesis() throws NoSuchAlgorithmException, IOException{
        Block gen = new Block("0");
        blockch.add(gen);
        write();
    }
    
    public void nextBlock(Block newBlock) throws IOException{
        newBlock.setIndex(blockch.getLast().getIndex());
        blockch.add(newBlock);
        write();
    }
    
    public LinkedList<Block> read() throws IOException{
        try {
            FileInputStream fin = new FileInputStream(this.ledgerFile);
            ObjectInputStream oin = new ObjectInputStream(fin);
            return (LinkedList<Block>)oin.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Blockchain.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void write() throws IOException{
        try (FileOutputStream fout = new FileOutputStream(this.ledgerFile);
                ObjectOutputStream oout = new ObjectOutputStream(fout);){
            oout.writeObject(blockch);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
