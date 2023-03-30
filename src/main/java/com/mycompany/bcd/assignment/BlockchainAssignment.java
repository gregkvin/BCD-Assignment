/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bcd.assignment;

import Blockchain.Blockchain;
import static Blockchain.BlockLogic.certBlock;
import static Blockchain.BlockLogic.courseBlock;
import static Blockchain.BlockLogic.masterFolder;
import static Blockchain.BlockLogic.userBlock;
import static Blockchain.BlockLogic.publicKeyBlock;
import LoginUI.MainMenu;
import com.google.gson.GsonBuilder;
import java.io.File;

/**
 *
 * @author gregoriuskevin
 */
public class BlockchainAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

    if (!new File(masterFolder).exists()) {
        System.err.println("> creating Blockchain binary!");
        new File(masterFolder).mkdir();
    }
    
    Blockchain userBlockchain = Blockchain.getInstance(userBlock);
    Blockchain certBlockchain = Blockchain.getInstance(certBlock);
    Blockchain courseBlockchain = Blockchain.getInstance(courseBlock);
    Blockchain publicKey = Blockchain.getInstance(publicKeyBlock);

    String chain = new GsonBuilder().setPrettyPrinting().create().toJson(userBlockchain.get());
    System.out.println(chain);
        
    MainMenu form = new MainMenu();
        form.setVisible(true);
    }
    
}
