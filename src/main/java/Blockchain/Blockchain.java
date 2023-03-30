/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blockchain;

/**
 *
 * @author putubgs
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.HashMap;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private static HashMap<String, Blockchain> instances = new HashMap<>();
    private String chainFile;
    private LinkedList<Block> db;

    private Blockchain(String chainFile) {
        this.chainFile = chainFile;
        if (isFileExist(chainFile)) {
            this.db = get();
        } else {
            genesis();
        }
        System.out.println("> Blockchain object is created!");
    }

    public static synchronized Blockchain getInstance(String chainFile) {
        if (!instances.containsKey(chainFile)) {
            Blockchain instance = new Blockchain(chainFile);
            if (!new File(chainFile).exists()) {
                instance.genesis();
            }
            instances.put(chainFile, instance);
        }
        return instances.get(chainFile);
    }

    private boolean isFileExist(String fileName) {
        File file = new File(fileName);
        return file.exists() && !file.isDirectory();
    }

    private void genesis() {
        Block genesis = new Block(0, "0");
        this.db = new LinkedList<>();
        this.db.add(genesis);
        persist();
    }

    public void nextBlock(Block newBlock) {
        int newIndex = this.db.size();
        newBlock.getBlockHeader().setIndex(newIndex);
        this.db.add(newBlock);
        persist();
    }

    public LinkedList<Block> get() {
        if (this.db == null) {
            try (FileInputStream fin = new FileInputStream(chainFile);
                 ObjectInputStream in = new ObjectInputStream(fin)) {
                this.db = (LinkedList<Block>) in.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.db;
    }

    private void persist() {
        try (FileOutputStream fout = new FileOutputStream(chainFile);
             ObjectOutputStream out = new ObjectOutputStream(fout)) {
            out.writeObject(this.db);
            System.out.println(">> Master file is updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBlock(int index, Block updatedBlock) {
        if (index >= 0 && index < this.db.size()) {
            this.db.set(index, updatedBlock);
            persist();
        } else {
            System.out.println(">> Invalid block index provided!");
        }
    }

    public void distribute() {
        LinkedList<Block> chain = get();
        String chainJson = new GsonBuilder().setPrettyPrinting().create().toJson(chain);
        System.out.println(chainJson);
    }
    
    public List<String> getLastBlockData() {
        LinkedList<Block> db = get();
        if (db != null && !db.isEmpty()) {
            return db.getLast().tranxLst.getDataLst();
        }
        return new ArrayList<>();
    }
}
