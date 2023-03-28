///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Blockchain;
//
///**
// *
// * @author putubgs
// */
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.LinkedList;
//import com.google.gson.GsonBuilder;
//
//public class Blockchain {
//    private static LinkedList<Blockchain.Block> db = new LinkedList<>();
//    private static Blockchain _instance;
//    public static Blockchain getInstance( String chainFile ) {
//        if(_instance == null)
//            _instance = new Blockchain( chainFile );
//        return _instance;
//    }
//    
//    public String chainFile;
//    public Blockchain(String chainFile) {
//        super();
//        this.chainFile = chainFile;
//        System.out.println( "> Blockchain object is created!" );
//    }
//    
//    public void genesis() {
//        Blockchain.Block genesis = new Blockchain.Block(0, "0");
//        db.add(genesis);
//        persist();
//    }
//
//    
//    public void nextBlock(Blockchain.Block newBlock) {
//        db = get();
//        int newIndex = db.size(); // Get the size of the current blockchain
//        newBlock.getBlockHeader().setIndex(newIndex); // Set the new index value for the block
//        db.add(newBlock);
//        persist();
//    }
//
//    
//    public LinkedList<Blockchain.Block> get()
//    {
//        try( FileInputStream fin = new FileInputStream( this.chainFile ); 
//             ObjectInputStream in = new ObjectInputStream( fin );
//            ) {
//            return (LinkedList<lab4.Block>)in.readObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    
//    private void persist()
//    {
//        try( FileOutputStream fout = new FileOutputStream( this.chainFile );
//             ObjectOutputStream out = new ObjectOutputStream( fout );
//            ) {
//            out.writeObject(db);
//            System.out.println( ">> Master file is updated!" );
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
//    /**     * distribute()     */
//    public void distribute(){
//        String chain = new GsonBuilder().setPrettyPrinting().create().toJson(db);
//        System.out.println(chain);
//    }
//}
