/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Blockchain;

import Class.User;
import java.io.File;

/**
 *
 * @author putubgs
 */
public class CreateBlock {

    private static String masterFolder = "src/main/java/master";
    private static String fileName = masterFolder+"/user_information.bin";
    
    public void userBlock(){
        Blockchain bc = Blockchain.getInstance( fileName );
        if ( !new File(masterFolder).exists() ) {
            System.err.println( "> creating Blockchain binary !" );
            new File(masterFolder).mkdir();
            bc.genesis();
        } else {
//            String line1 = "reno|alice|debit|100|hohoho";
//            String line2 = "diva|alice|debit|200|hahaha";
            User user = new User("bagus", "Bagus Bobby", "password124", "Male","1990-01-02", "bagus@example.com");
            
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
    
    }

}