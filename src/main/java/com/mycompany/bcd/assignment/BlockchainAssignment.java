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
        
        Blockchain bc = new Blockchain(userBlock);
        Blockchain bc2 = new Blockchain(certBlock);
        Blockchain bc3 = new Blockchain(courseBlock);
        String chain = new GsonBuilder().setPrettyPrinting().create().toJson(userBlock);
        System.out.println(chain);
        if ( !new File(masterFolder).exists() ) {
            System.err.println( "> creating Blockchain binary !" );
            new File(masterFolder).mkdir();
            bc.genesis();
            bc2.genesis();
            bc3.genesis();
        }
        
        MainMenu form = new MainMenu();
        form.setVisible(true);
    }
    
}
