/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bcd.assignment;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

/**
 *
 * @author gregoriuskevin
 */
public class Block {
    
    public int index;
    public String currHash, prevHash;
    public long timestamp;
    public Transaction trans;
    Hashing h = new Hashing();
    
    public Block(String prevHash) throws NoSuchAlgorithmException {
        setTimestamp( new Timestamp(System.currentTimeMillis()).getTime() );
        setPrevHash(prevHash);
        String input = String.join("+", Integer.toString(getIndex()), Long.toString(getTimestamp()), getPrevHash());
        String block = h.hash(input);
        setCurrHash( block );
        
    }
    

        public int getIndex(){
            return index;
        }
        
        public String getCurrHash(){
            return currHash;
        } 
        
        public String getPrevHash(){
            return prevHash;
        }
        
        public long getTimestamp(){
            return timestamp;
        }
        
        public void setIndex(int index){
            this.index = index;
        }
        
        public void setCurrHash(String currHash){
            this.currHash = currHash;
        }
        
        public void setPrevHash(String prevHash){
            this.prevHash = prevHash;
        }
        
        public void setTimeStamp(long timestamp){
            this.timestamp = timestamp;
        }

        private void setTimestamp(long time) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        public Transaction getTrans(){
            return trans;
        }
        
        public void setTrans(){
            this.trans=trans;
        }
    }
    

