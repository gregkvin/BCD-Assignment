/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bcd.assignment;

/**
 *
 * @author gregoriuskevin
 */
public class Block {
    
    public Header header;
    public Block(String prevHash) {
        header = new Header();
        
    }
    
    public class Header {
        //private static final long serialVersionUID = 1L ;
        public int index;
        public String currHash, prevHash;
        public long timestamp;
        
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
    }
    
}
